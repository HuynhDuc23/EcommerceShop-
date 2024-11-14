package vn.haibazo.account_service.service;

import vn.haibazo.account_service.dto.request.AccountRequest;
import vn.haibazo.account_service.dto.request.LoginRequest;
import vn.haibazo.account_service.dto.response.AccountResponse;
import vn.haibazo.account_service.dto.response.AuthenticationResponse;
import vn.haibazo.account_service.dto.response.LoginResponse;
import vn.haibazo.account_service.entity.Account;

public interface AccountService {
    public AccountResponse create(AccountRequest request);

    public LoginResponse login(LoginRequest loginRequest) throws Exception;

}
