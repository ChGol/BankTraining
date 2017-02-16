package com.training.chgol.service;

import com.training.chgol.entity.Account;
import com.training.chgol.operation.Operation;
import com.training.chgol.service.repository.AccountsRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountsService {

    private AccountsRepository accountsRepository;
    private AccountNumberGenerator accountNumberGenerator;

    public AccountsService(AccountsRepository accountsRepository, AccountNumberGenerator accountNumberGenerator) {
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


    public void init() {
        System.out.println("Accounts Service init............");
    }


    public void destroy() {
        System.out.println("Accounts Service destroy..............");
    }

}
