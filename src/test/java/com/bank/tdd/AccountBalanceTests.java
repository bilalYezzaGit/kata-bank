package com.bank.tdd;

import com.bank.Account;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountBalanceTests {

    @Test
    void deposit_20_to_new_account() {
        // GIVEN
        LocalDate now = LocalDate.now();
        Account account = new Account();

        // WHEN
        account.deposit(new BigDecimal(20), now);

        // THEN
        assertEquals(new BigDecimal(20), account.getBalance());
    }

    @Test
    void deposit_2_times_20_to_new_account() {
        // GIVEN
        LocalDate now = LocalDate.now();
        Account account = new Account();

        // WHEN
        account.deposit(new BigDecimal(20), now);
        account.deposit(new BigDecimal(20), now);

        // THEN
        assertEquals(new BigDecimal(40), account.getBalance());
    }

    @Test
    void withdrawal_100_after_adding_3_times_50() {
        // GIVEN
        LocalDate now = LocalDate.now();
        Account account = new Account();

        // WHEN
        account.deposit(new BigDecimal(50), now);
        account.deposit(new BigDecimal(50), now);
        account.deposit(new BigDecimal(50), now);
        account.withdraw(new BigDecimal(100), now);

        // THEN
        assertEquals(new BigDecimal(50), account.getBalance());
    }

}