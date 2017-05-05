package com.training.chgol.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import com.training.chgol.operation.ConsoleOperationLogger;
import com.training.chgol.service.AccountNumberGenerator;
import com.training.chgol.service.AccountsService;
import com.training.chgol.service.HibernateIncrementalAccountNumberGenerator;
import com.training.chgol.service.repository.AccountsRepository;

@Import(Repository.class)
@EnableAspectJAutoProxy
@Configuration
public class Beans {

    @Bean
    public AccountNumberGenerator accountNumberGenerator(SessionFactory sessionFactory) {
        return new HibernateIncrementalAccountNumberGenerator(sessionFactory);
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
