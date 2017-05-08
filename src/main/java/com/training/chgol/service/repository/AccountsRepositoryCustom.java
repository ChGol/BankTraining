package com.training.chgol.service.repository;

import com.training.chgol.entity.Account;

public interface AccountsRepositoryCustom {

    Account getByNumber(String accountNumber);

}
