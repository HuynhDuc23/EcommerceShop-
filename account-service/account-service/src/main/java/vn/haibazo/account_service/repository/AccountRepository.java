package vn.haibazo.account_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.haibazo.account_service.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    public Account findByUsername(String username);
}
