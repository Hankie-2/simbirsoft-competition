package com.example.itplanet.controller;

import com.example.itplanet.model.request.AccountRequest;
import com.example.itplanet.model.response.AccountResponse;
import com.example.itplanet.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    /**
     * Получение информации об аккаунте пользователя
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable("accountId") Long id){
        if(id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AccountResponse response = accountService.getAccountById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /**
     * Поиск аккаунтов пользователей по параметрам
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchAccounts(@RequestParam(value = "firstName", required = false) String firstName,
                                            @RequestParam(value = "lastName", required = false) String lastName,
                                            @RequestParam(value = "email", required = false) String email,
                                            @RequestParam(value = "from", required = false, defaultValue = "0") Integer from,
                                            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
    ){
        if(from == null || size == null || from < 0 || size <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(accountService.searchAccountsByFilter(firstName,lastName,email,from,size),HttpStatus.OK);
    }

    /**
     * Обновление данных аккаунта пользователя
     */
    @PutMapping("/{accountId}")
    public ResponseEntity<?> updateAccountById(@PathVariable("accountId") Long id,
                                               @RequestBody AccountRequest request){
        if( id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(accountService.updateAccountById(id,request),HttpStatus.OK);
    }

    /**
     * Удаление аккаунта пользователя
     */
    @DeleteMapping("/{accountId}")
    public ResponseEntity<?> deleteAccountById(@PathVariable("accountId") Long id){
        if(id == null || id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        accountService.deleteAccountById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
