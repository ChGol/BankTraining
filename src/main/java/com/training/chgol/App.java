package com.training.chgol;

import com.training.chgol.config.Beans;
import com.training.chgol.entity.Account;
import com.training.chgol.operation.DepositOperation;
import com.training.chgol.operation.TransferOperation;
import com.training.chgol.operation.WithdrawOperation;
import com.training.chgol.service.AccountsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Beans.class)) {

            AccountsService accountsService = applicationContext.getBean(AccountsService.class);

            Account firstAccount = accountsService.createAccount();
            Account secondAccount = accountsService.createAccount();

            accountsService.process(new DepositOperation(firstAccount.getNumber(), 1000));
            accountsService.process(new DepositOperation(secondAccount.getNumber(), 500));
            accountsService.process(new WithdrawOperation(firstAccount.getNumber(), 200));
            accountsService.process(new TransferOperation(firstAccount.getNumber(), secondAccount.getNumber(), 10));

            System.out.println(firstAccount);
            System.out.println(secondAccount);
        }
    }

}