package com.training.chgol.config;

import org.springframework.context.annotation.*;
import com.training.chgol.operation.ConsoleOperationLogger;
import com.training.chgol.operation.OperationFactory;
import com.training.chgol.service.AccountNumberGenerator;
import com.training.chgol.service.AccountsService;
import com.training.chgol.service.JpaIncrementalAccountNumberGenerator;
import com.training.chgol.service.repository.AccountsRepository;

import javax.persistence.EntityManagerFactory;

@ComponentScan("com.training.chgol.operation")
@Import(Repository.class)
@EnableAspectJAutoProxy
@Configuration
public class Beans {

    @Bean
    public AccountNumberGenerator accountNumberGenerator(EntityManagerFactory entityManagerFactory) {
        return new JpaIncrementalAccountNumberGenerator(entityManagerFactory);
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

    @Bean
    public OperationFactory operationFactory() {
        return new OperationFactory();
    }

}