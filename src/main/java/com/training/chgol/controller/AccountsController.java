package com.training.chgol.controller;

import com.training.chgol.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.training.chgol.entity.Account;

@Controller
public class AccountsController {

    private AccountsService accountsService;

    @Autowired
    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @RequestMapping("createAccount.html")
    public ModelAndView create() {
        Account account = accountsService.createAccount();
        ModelAndView modelAndView = new ModelAndView("createAccountConfirmation");
        modelAndView.addObject(account);
        return modelAndView;
    }

}
