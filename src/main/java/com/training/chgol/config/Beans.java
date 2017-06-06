package com.training.chgol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.training.chgol.dto.DtoMapper;
import com.training.chgol.operation.ConsoleOperationLogger;
import com.training.chgol.operation.OperationFactory;
import com.training.chgol.service.AccountNumberGenerator;
import com.training.chgol.service.AccountsService;
import com.training.chgol.service.JpaIncrementalAccountNumberGenerator;
import com.training.chgol.service.repository.AccountsRepository;

import javax.persistence.EntityManagerFactory;

@EnableJpaRepositories(basePackages = "com.training.chgol.service.repository")
@Configuration
public class Beans {

    @Bean
    public AccountNumberGenerator accountNumberGenerator(EntityManagerFactory entityManagerFactory) {
        return new JpaIncrementalAccountNumberGenerator(entityManagerFactory);
    }

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

    @Bean
    public DtoMapper dtoMapper() {
        return new DtoMapper();
    }

}
