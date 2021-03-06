package com.training.chgol.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.training.chgol.dto.AccountDto;
import com.training.chgol.dto.AccountsListDto;
import com.training.chgol.dto.DtoMapper;
import com.training.chgol.entity.Account;
import com.training.chgol.service.AccountsService;
import com.training.chgol.service.repository.ResultPage;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RequestMapping(value = "api/accounts", produces = {"application/json"})
@RestController
public class AccountsResource {

    private AccountsService accountsService;
    private DtoMapper dtoMapper;

    @Autowired
    public AccountsResource(AccountsService accountsService, DtoMapper dtoMapper) {
        this.accountsService = accountsService;
        this.dtoMapper = dtoMapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create() {
        Account account = accountsService.createAccount();
        URI uri = createUriForId(account.getId());
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public AccountsListDto getAccounts(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<Account> resultPage = accountsService.getAccounts(pageNumber, pageSize);
        List<AccountDto> accountDtos = dtoMapper.map(resultPage.getContent(), AccountDto.class);
        return new AccountsListDto(accountDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }

    private URI createUriForId(long id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(id).toUri();
    }


}
