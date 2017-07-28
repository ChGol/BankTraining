package com.training.chgol.service;

import com.training.chgol.service.repository.ResultPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import com.training.chgol.entity.Account;
import com.training.chgol.operation.Operation;
import com.training.chgol.service.repository.AccountsRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional
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

    public ResultPage<Account> getAccounts(int pageNumber, int pageSize) {
        Page<Account> accountsPage = accountsRepository.findAll(new PageRequest(pageNumber, pageSize));
        return new ResultPage<>(accountsPage.getContent(), accountsPage.getNumber(), accountsPage.getTotalPages());
    }

    public void init() {
        System.out.println("AccountsService init...");
    }

    public void destroy() {
        System.out.println("AccountsService destroy...");
    }

}
