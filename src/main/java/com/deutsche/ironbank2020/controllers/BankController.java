package com.deutsche.ironbank2020.controllers;

import com.deutsche.ironbank2020.dto.Loan;
import com.deutsche.ironbank2020.model.Bank;
import com.deutsche.ironbank2020.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/bank")
public class BankController {


    @Autowired
    private BankService bankService;

    @GetMapping("/total")
    public String getTotalMoneyInBank() {
        Bank bank = bankService.getBank();
        return "total amount: " + bank.getAmount();
    }

    @GetMapping("/loan")
    public String loan(@RequestParam("name") String userName, @RequestParam int amount) {
        return bankService.loan(Loan.builder().userName(userName).amount(amount).build());
    }


}
