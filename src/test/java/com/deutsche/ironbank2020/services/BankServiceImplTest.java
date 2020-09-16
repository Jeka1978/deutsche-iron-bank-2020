package com.deutsche.ironbank2020.services;

import com.deutsche.ironbank2020.dto.Loan;
import com.ironbank.ironbankstarter2020.exceptions.NotEnoughMoneyException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceMockConf.class)
//@ActiveProfiles
public class BankServiceImplTest {


//    @MockBean
//    BankRepo bankRepo;
//
//    @Before
//    public void setUp() throws Exception {
//        Mockito.when(bankRepo.findAll()).thenReturn(List.of(Bank.builder().amount(200).build()));
//    }

    @Autowired

    private BankService bankService;

    @Test
//    @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
    public void loanRejectedForStarks() {
        String answer = bankService.loan(new Loan("Nedd stark", 100));
        Assert.assertTrue(answer.toLowerCase().contains("reject"));
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void exceptionWillBeThrownWhenTryingToLoanMoreMoneyThanWeHave() {
        bankService.loan(new Loan("Lanister", 300));
    }
}




