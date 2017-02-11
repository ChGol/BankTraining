package com.training.chgol.service;

import com.training.chgol.entity.Account;
import com.training.chgol.operation.Operation;
import com.training.chgol.service.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Service
public class AccountsService {

    private AccountsRepository accountsRepository;
    private AccountNumberGenerator accountNumberGenerator;

    @Autowired
    public AccountsService(AccountsRepository accountsRepository, @Qualifier("fakeAccountNumberGenerator") AccountNumberGenerator accountNumberGenerator) {
        this.accountsRepository = accountsRepository;
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public Account createAccount() {
        Account account = new Account(accountNumberGenerator.getNext());
        accountsRepository.save(account);
        return account;
    }

    public void process(Operation operation) {
        operation.setAccountsRepository(accountsRepository);
        operation.execute();
    }

    public List<Account> getAccounts(int pageNumber, int pageSize) {
        return new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        System.out.println("AccountsService init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AccountsService destroy...");
    }

}
