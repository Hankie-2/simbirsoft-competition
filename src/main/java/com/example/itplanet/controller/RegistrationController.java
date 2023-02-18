package com.example.itplanet.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    /**
     *  Регистрация нового аккаунта
     */
//    @PostMapping("/registration")
//    public ResponseEntity<?> registrationAccount(@RequestBody @Valid AccountRequest request,
//                                                 @RequestHeader("Authorization") String authorization)
//    {
//        if(authorization == null){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//        AccountResponse accountVerification = requestHeaderHandler.verificationEmailAndPassword(authorization);
//
//        AccountResponse accountByEmail =
//
//        AccountResponse response = accountService.save(request);
//        if(response == null){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }

}
