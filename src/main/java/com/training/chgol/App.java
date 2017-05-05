package com.training.chgol;

import com.training.chgol.entity.Account;
import com.training.chgol.operation.DepositOperation;
import com.training.chgol.operation.TransferOperation;
import com.training.chgol.operation.WithdrawOperation;
import com.training.chgol.service.AccountsService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext("beans.xml")) {

            AccountsService accountsService = applicationContext.getBean(AccountsService.class);

            Account firstAccount = accountsService.createAccount();
            Account secondAccount = accountsService.createAccount();
            Account thirdAccount = accountsService.createAccount();

            accountsService.process(new DepositOperation(firstAccount.getNumber(), 1200));
            accountsService.process(new DepositOperation(secondAccount.getNumber(), 700));
            accountsService.process(new WithdrawOperation(firstAccount.getNumber(), 300));
            accountsService.process(new TransferOperation(firstAccount.getNumber(),
                    secondAccount.getNumber(), 20));
            accountsService.process(new TransferOperation(secondAccount.getNumber(),
                    thirdAccount.getNumber(), 20));

            System.out.println(firstAccount);
            System.out.println(secondAccount);
            System.out.println(thirdAccount);
        }
    }

}