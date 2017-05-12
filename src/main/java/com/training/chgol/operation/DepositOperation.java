package com.training.chgol.operation;

import com.training.chgol.entity.Account;

@OperationComponent
public class DepositOperation extends Operation {

    public DepositOperation(String sourceAccountNumber, long funds) {
        super(sourceAccountNumber, funds);
    }

    public DepositOperation() {
    }

    @Override
    public void execute() {
       Account account = accountsRepository.getByNumber(sourceAccountNumber);
       account.deposit(funds);
       accountsRepository.save(account);
    }

    @Override
    public String toString() {
        return String.format("%s <== %s", sourceAccountNumber, formatCurrency(funds));
    }

}
