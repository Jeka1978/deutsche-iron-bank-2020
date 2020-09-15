package com.deutsche.ironbank2020.dao;

import com.deutsche.ironbank2020.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evgeny Borisov
 */
public interface BankRepo extends JpaRepository<Bank,Integer> {
}
