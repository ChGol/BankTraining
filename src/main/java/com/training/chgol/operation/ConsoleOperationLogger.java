package com.training.chgol.operation;

import com.training.chgol.BankException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ConsoleOperationLogger {

    private static final String SEPARATOR = "####################################################################";

    @Pointcut("execution(void com.training.chgol.service.AccountsService.process(..)) && args(operation)")
    public void processOperation(Operation operation) {
    }

    public void beforeOperation(Operation operation) {
        System.out.println(SEPARATOR);
        System.out.println(operation);
    }

    @AfterReturning("processOperation(operation)")
    public void onSuccess(Operation operation) {
        System.out.format("Status: success\n%s\n", SEPARATOR);
    }

    @AfterThrowing(value = "processOperation(operation)", throwing = "ex")
    public void onException(Operation operation, BankException ex) {
        System.out.format("Status: exception (%s)\n%s\n", ex.getClass().getSimpleName(), SEPARATOR);
    }

}
