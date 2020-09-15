package com.deutsche.ironbank2020.controllers;

import com.deutsche.ironbank2020.dao.BankRepo;
import com.deutsche.ironbank2020.dto.Loan;
import com.deutsche.ironbank2020.exceptions.NotEnoughMoneyException;
import com.deutsche.ironbank2020.services.BankService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceMockConf.class)
@MockBean(BankRepo.class)
public class BankServiceImplTest {


    @Autowired
    private BankService bankService;

    @Test
    public void loanRejectedForStarks() {
        String answer = bankService.loan(new Loan("Nedd stark", 100));
        Assert.assertTrue(answer.toLowerCase().contains("reject"));
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void exceptionWillBeThrownWhenTryingToLoanMoreMoneyThanWeHave() {
        bankService.loan(new Loan("Lanister", 10));
    }
}




