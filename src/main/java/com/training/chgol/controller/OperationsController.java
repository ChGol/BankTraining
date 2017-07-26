package com.training.chgol.controller;

import com.training.chgol.operation.Operation;
import com.training.chgol.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.training.chgol.operation.OperationResolver;
import com.training.chgol.viewmodel.OperationModel;


import javax.validation.Valid;

@RequestMapping("operationForm.html")
@Controller
public class OperationsController {

    private AccountsService accountsService;
    private OperationResolver operationResolver;

    @Autowired
    public OperationsController(AccountsService accountsService, OperationResolver operationResolver) {
        this.accountsService = accountsService;
        this.operationResolver = operationResolver;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showOperationForm() {
        ModelAndView modelAndView = new ModelAndView("operationForm");
        modelAndView.addObject(new OperationModel());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processOperation(@Valid OperationModel operationModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("operationForm");
        }


        Operation operation = operationResolver.get(operationModel.getName());
        operation.setSourceAccountNumber(operationModel.getSourceAccountNumber());
        operation.setDestinationAccountNumber(operationModel.getDestinationAccountNumber());
        operation.setFunds(operationModel.getFunds());
        accountsService.process(operation);

        ModelAndView modelAndView = new ModelAndView("processOperationConfirmation");
        modelAndView.addObject("operation", operationModel);
        modelAndView.addObject("sourceAccount", accountsService.getAccountByNumber(operationModel.getSourceAccountNumber()));
        if (operationModel.getName().equals("transferOperation")) {
            modelAndView.addObject("destinationAccount", accountsService.getAccountByNumber(operationModel.getDestinationAccountNumber()));
        }
        modelAndView.addObject("sourceAccount", accountsService.getAccountByNumber(operationModel.getSourceAccountNumber()));
        return modelAndView;
    }

}
