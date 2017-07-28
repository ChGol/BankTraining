package com.training.chgol.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.training.chgol.dto.ExceptionDto;
import com.training.chgol.dto.OperationDto;
import com.training.chgol.operation.InsufficientFundsException;
import com.training.chgol.operation.NoSuchOperationException;
import com.training.chgol.operation.Operation;
import com.training.chgol.operation.OperationResolver;
import com.training.chgol.service.AccountsService;
import com.training.chgol.service.repository.AccountNotFoundException;

@CrossOrigin
@RequestMapping(value = "api/operations")
@RestController
public class OperationsResource {

    private AccountsService accountsService;
    private OperationResolver operationResolver;

    @Autowired
    public OperationsResource(AccountsService accountsService, OperationResolver operationResolver) {
        this.accountsService = accountsService;
        this.operationResolver = operationResolver;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity process(@RequestBody OperationDto operationDto) {
        Operation operation = operationResolver.get(operationDto.getName());
        operation.setSourceAccountNumber(operationDto.getSourceAccountNumber());
        operation.setDestinationAccountNumber(operationDto.getDestinationAccountNumber());
        operation.setFunds(operationDto.getFunds());
        accountsService.process(operation);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity handleAccountNotFound() {
        return new ResponseEntity(new ExceptionDto(ExceptionDto.Type.ACCOUNT_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity handleInsufficientFunds() {
        return new ResponseEntity(new ExceptionDto(ExceptionDto.Type.INSUFFICIENT_FUNDS), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(NoSuchOperationException.class)
    public ResponseEntity handleUnknownOperation() {
        return new ResponseEntity(new ExceptionDto(ExceptionDto.Type.UNKNOWN_OPERATION), HttpStatus.BAD_REQUEST);
    }

}
