package vn.haibazo.account_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.haibazo.account_service.dto.request.AccountRequest;
import vn.haibazo.account_service.dto.request.LoginRequest;
import vn.haibazo.account_service.dto.response.AccountResponse;
import vn.haibazo.account_service.dto.response.AuthenticationResponse;
import vn.haibazo.account_service.dto.response.LoginResponse;
import vn.haibazo.account_service.service.AccountService;

@RestController
@RequestMapping("/auth")
public class AccountController {
    @Autowired
    private AccountService accountService ;
    @PostMapping("/register")
    public AccountResponse createAccount(@RequestBody AccountRequest accountRequest) {
      return this.accountService.create(accountRequest);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        return this.accountService.login(loginRequest);
    }

}

