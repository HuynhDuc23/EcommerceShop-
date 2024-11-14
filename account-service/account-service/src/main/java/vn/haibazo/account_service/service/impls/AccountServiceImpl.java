package vn.haibazo.account_service.service.impls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.haibazo.account_service.dto.request.AccountRequest;
import vn.haibazo.account_service.dto.request.LoginRequest;
import vn.haibazo.account_service.dto.response.AccountResponse;
import vn.haibazo.account_service.dto.response.LoginResponse;
import vn.haibazo.account_service.entity.Account;
import vn.haibazo.account_service.repository.AccountRepository;
import vn.haibazo.account_service.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private AccountRepository accountRepository ;
    @Override
    public AccountResponse create(AccountRequest request) {
        Account account = new Account();
        account.setUsername(request.getUsername());
        account.setPassword(this.passwordEncoder.encode(request.getPassword()));
        var results = this.accountRepository.save(account);
        return new AccountResponse().builder().username(results.getUsername()).password(results.getPassword()).build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        var account = this.accountRepository.findByUsername(loginRequest.getUsername());

        boolean authenticated = passwordEncoder.matches(loginRequest.getPassword(), account.getPassword());
        if (!authenticated) {
            throw new Exception("Failed authentication request");
        }
        return new LoginResponse().builder().username(account.getUsername()).password(account.getPassword()).build();

    }
}
