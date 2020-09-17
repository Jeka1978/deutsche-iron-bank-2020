package com.deutsche.ironbank2020.services;

import com.deutsche.ironbank2020.dao.BankRepo;
import com.deutsche.ironbank2020.dto.Loan;
import com.deutsche.ironbank2020.model.Bank;
import com.ironbank.ironbankstarter2020.exceptions.NotEnoughMoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
@EnableAsync
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private PredictionService predictionService;

    @Override
    public Bank getBank() {
        return bankRepo.findAll().get(0);
    }

    @Override
    public String loan(Loan loan) {
        Bank bank = bankRepo.findAll().get(0);

        if (bank.getAmount() < loan.getAmount()) {
            throw new NotEnoughMoneyException("no more money");
        }

        boolean willSurvive = predictionService.willSurvive(loan.getUserName());
        if (willSurvive) {
            bank.setAmount(bank.getAmount() - loan.getAmount());
            return "money transfer";
        } else {
            return "rejected, you will die soon, or we just don't like you";
        }

    }
}
