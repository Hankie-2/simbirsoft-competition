package com.example.itplanet.service;

import com.example.itplanet.exception.account.AccountAuthenticationException;
import com.example.itplanet.exception.account.AccountNotFound;
import com.example.itplanet.model.entity.Account;
import com.example.itplanet.model.mapper.AccountMapper;
import com.example.itplanet.model.response.AccountResponse;
import com.example.itplanet.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Service
@AllArgsConstructor
public class RequestHeaderHandler {

    private final AccountRepository accountRepository;

    public AccountResponse verificationEmailAndPassword(String text){
        String decodedEmail = decodeAndReturnEmailAndPassword(text)[0];
        String decodedPassword = decodeAndReturnEmailAndPassword(text)[1];

        Account account = accountRepository.findAccountByEmailAndPassword(decodedEmail,decodedPassword);
        if(account == null){
            throw new AccountNotFound(HttpStatus.FORBIDDEN);
        }

        return AccountMapper.INSTANCE.toDto(account);
    }

    private String[] decodeAndReturnEmailAndPassword(String text){
        String decodedHeader = new String(Base64.getDecoder().decode(text.substring(6)), StandardCharsets.UTF_8);

        int index = decodedHeader.indexOf(':');
        if(index < 0){
            throw new AccountAuthenticationException(HttpStatus.UNAUTHORIZED);
        }
        String email = decodedHeader.substring(0,index);
        String password = decodedHeader.substring(index + 1);

        return new String[]{email,password};
    }


}
