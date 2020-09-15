package com.deutsche.ironbank2020.services;

import com.deutsche.ironbank2020.dao.BankRepo;
import com.deutsche.ironbank2020.dto.Loan;
import com.deutsche.ironbank2020.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepo bankRepo;

    @Override
    public Bank getBank() {
        return bankRepo.findAll().get(0);
    }

    @Override
    public String loan(Loan loan) {
        Bank bank = bankRepo.findAll().get(0);
        if (bank.getAmount() > 0) {
            return "loan accepted";
        }
        return "rejected";
    }
}
