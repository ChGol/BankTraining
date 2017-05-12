package com.training.chgol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.training.chgol.dto.AccountDto;
import com.training.chgol.dto.AccountsListDto;
import com.training.chgol.dto.DtoMapper;
import com.training.chgol.dto.ExceptionDto;
import com.training.chgol.entity.Account;
import com.training.chgol.service.AccountsService;
import com.training.chgol.service.repository.AccountNotFoundException;
import com.training.chgol.service.repository.ResultPage;

import java.net.URI;
import java.util.List;

import static com.training.chgol.dto.ExceptionDto.Type.ACCOUNT_NOT_FOUND;

@CrossOrigin
@RequestMapping(value = "api/accounts", produces = {"application/xml", "application/json"})
@RestController
public class AccountsController {

    private AccountsService accountsService;
    private DtoMapper dtoMapper;

    @Autowired
    public AccountsController(AccountsService accountsService, DtoMapper dtoMapper) {
        this.accountsService = accountsService;
        this.dtoMapper = dtoMapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create() {
        Account account = accountsService.createAccount();
        URI uri = createUriForId(account.getId());
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public AccountDto getById(@PathVariable("id") long id) {
        Account account = accountsService.getById(id);
        return dtoMapper.map(account, AccountDto.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public AccountsListDto getAccounts(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        ResultPage<Account> accountsPage = accountsService.getAccounts(pageNumber, pageSize);
        List<AccountDto> accountDtos = dtoMapper.map(accountsPage.getContent(), AccountDto.class);
        return new AccountsListDto(accountDtos, accountsPage.getPageNumber(), accountsPage.getTotalPages());
    }

    private URI createUriForId(long id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity onAccountNotFound() {
        return new ResponseEntity(new ExceptionDto(ACCOUNT_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

}
