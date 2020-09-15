package com.deutsche.ironbank2020.services;

import com.deutsche.ironbank2020.dto.Loan;
import com.deutsche.ironbank2020.model.Bank;

/**
 * @author Evgeny Borisov
 */
public interface BankService {
    Bank getBank();

    String loan(Loan loan);
}
