package com.example.itplanet.service;


import com.example.itplanet.model.request.AccountRequest;
import com.example.itplanet.model.response.AccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {

    AccountResponse save(AccountRequest request);
    AccountResponse getAccountById(Long id);
    AccountResponse updateAccountById(Long id,AccountRequest request);
    void deleteAccountById(Long id);
    List<AccountResponse> searchAccountsByFilter(String firstName, String lastName, String email, Integer from, int size);
    AccountResponse getAccountByEmailAndPassword(String email, String password);

    AccountResponse getAccountByEmail(String email);

}