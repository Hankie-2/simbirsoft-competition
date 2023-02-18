package com.example.itplanet.service.impl;

import com.example.itplanet.exception.account.AccountAuthenticationException;
import com.example.itplanet.exception.account.AccountIsExists;
import com.example.itplanet.exception.account.AccountNotFound;
import com.example.itplanet.exception.animal.AnimalIsExists;
import com.example.itplanet.model.entity.Account;
import com.example.itplanet.model.mapper.AccountMapper;
import com.example.itplanet.model.request.AccountRequest;
import com.example.itplanet.model.response.AccountResponse;
import com.example.itplanet.repository.AccountRepository;
import com.example.itplanet.service.AccountService;
import com.example.itplanet.service.AnimalService;
import com.example.itplanet.service.RequestHeaderHandler;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RequestHeaderHandler requestHeaderHandler;
    private final AnimalService animalService;

    @Override
    public AccountResponse save(AccountRequest request) {
        Account account = accountRepository.findAccountByEmail(request.getEmail());
        if(account!=null){
            throw new AccountIsExists(HttpStatus.BAD_REQUEST);
        }
        Account registered = accountRepository.save(
                Account.builder()
                        .email(request.getEmail().trim())
                        .firstName(request.getFirstName().trim())
                        .lastName(request.getLastName().trim())
                        .password(request.getPassword().trim())
                        .build()
        );
        return AccountResponse.builder()
                .id(registered.getId())
                .email(registered.getEmail())
                .lastName(registered.getLastName())
                .firstName(registered.getFirstName())
                .build();
    }

    @Override
    public AccountResponse getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFound(HttpStatus.NOT_FOUND));

        return new AccountResponse(account.getId(),account.getFirstName(),account.getLastName(),account.getEmail());
    }

    @Override
    public void deleteAccountById(Long id) {
        if(animalService.getAnimalByChipperId(id) != null){
            throw new AnimalIsExists(HttpStatus.BAD_REQUEST);
        }
        accountRepository.deleteById(id);
    }

    @Override
    public AccountResponse updateAccountById(Long id,AccountRequest request) {
        AccountResponse accountResponse = getAccountById(id);

        Account account = accountRepository.findAccountByEmail(request.getEmail());
        if(account!=null){
            throw new AccountIsExists(HttpStatus.CONFLICT);
        }

        return AccountMapper.INSTANCE
                .toDto(accountRepository.save(
                        AccountMapper.INSTANCE
                        .toEntity(accountResponse)));
    }

    @Override
    public List<AccountResponse> searchAccountsByFilter(String firstName, String lastName, String email, Integer from, int size) {
        Pageable pageable = PageRequest.of(0,size);
        Page<AccountResponse> pages =
                accountRepository.findAccountsByFirstNameLastNameEmail(firstName,lastName,email,pageable)
                .map(account ->
                        new AccountResponse(account.getId(),account.getFirstName(),account.getLastName(),account.getEmail())
                );
        return pages.stream()
                .map(accountResponse -> new AccountResponse(accountResponse.getId(), accountResponse.getFirstName(), accountResponse.getLastName(), accountResponse.getEmail()))
                .skip(from).toList();
    }

    @Override
    public AccountResponse getAccountByEmailAndPassword(String email, String password) {
        Account account = accountRepository.findAccountByEmailAndPassword(email,password);
        if(account == null){
            throw new AccountNotFound(HttpStatus.FORBIDDEN);
        }
        return AccountMapper.INSTANCE.toDto(account);
    }

    @Override
    public AccountResponse getAccountByEmail(String email) {

        Account account = accountRepository.findAccountByEmail(email);

        return null;
    }

}
