package com.training.chgol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.training.chgol.dto.ExceptionDto;
import com.training.chgol.dto.OperationDto;
import com.training.chgol.operation.InsufficientFundsException;
import com.training.chgol.operation.NoSuchOperationException;
import com.training.chgol.operation.Operation;
import com.training.chgol.operation.OperationFactory;
import com.training.chgol.service.AccountsService;
import com.training.chgol.service.repository.AccountNotFoundException;

import static com.training.chgol.dto.ExceptionDto.Type.*;

@CrossOrigin
@RequestMapping("api/operations")
@RestController
public class OperationsController {

    private AccountsService accountsService;
    private OperationFactory operationFactory;

    @Autowired
    public OperationsController(AccountsService accountsService, OperationFactory operationFactory) {
        this.accountsService = accountsService;
        this.operationFactory = operationFactory;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity process(@RequestBody OperationDto operationDto) {
        Operation operation = operationFactory.get(operationDto.getName());
        operation.setSourceAccountNumber(operationDto.getSourceAccountNumber());
        operation.setDestinationAccountNumber(operationDto.getDestinationAccountNumber());
        operation.setFunds(operationDto.getFunds());
        accountsService.process(operation);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity onAccountNotFound() {
        return new ResponseEntity(new ExceptionDto(ACCOUNT_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity onInsufficientFunds() {
        return new ResponseEntity(new ExceptionDto(INSUFFICIENT_FUNDS), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(NoSuchOperationException.class)
    public ResponseEntity onNoSuchOperationException() {
        return new ResponseEntity(new ExceptionDto(UNKNOWN_OPERATION), HttpStatus.BAD_REQUEST);
    }

}
