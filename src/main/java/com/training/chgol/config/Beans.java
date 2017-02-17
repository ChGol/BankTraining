package com.training.chgol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.training.chgol.operation.ConsoleOperationLogger;
import com.training.chgol.service.AccountNumberGenerator;
import com.training.chgol.service.AccountsService;
import com.training.chgol.service.IncrementalAccountNumberGenerator;
import com.training.chgol.service.repository.AccountsRepository;
import com.training.chgol.service.repository.HashMapAccountsRepository;

@EnableAspectJAutoProxy
@Configuration
public class Beans {

    @Bean
    public AccountNumberGenerator accountNumberGenerator() {
        return new IncrementalAccountNumberGenerator();
    }

    @Bean
    public AccountsRepository accountsRepository() {
        return new HashMapAccountsRepository();
    }

    //@Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AccountsService accountsService(AccountsRepository accountsRepository, AccountNumberGenerator accountNumberGenerator) {
        return new AccountsService(accountsRepository, accountNumberGenerator);
    }

    @Bean
    public ConsoleOperationLogger operationLogger() {
        return new ConsoleOperationLogger();
    }

}
