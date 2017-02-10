package com.training.chgol.service.repository;

import com.training.chgol.entity.Account;

public interface AccountsRepository {

    Account save(Account account);

    Account getByNumber(String sourceAccountNumber);

    void update(Account account);

}
