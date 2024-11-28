package vn.haibazo.account_service.service;

import vn.haibazo.ecommerce_service.dto.response.request.AccountRequest;
import vn.haibazo.ecommerce_service.dto.response.request.LoginRequest;
import vn.haibazo.account_service.dto.response.AccountResponse;
import vn.haibazo.account_service.dto.response.LoginResponse;

public interface AccountService {
    public AccountResponse create(AccountRequest request);

    public LoginResponse login(LoginRequest loginRequest) throws Exception;

}
