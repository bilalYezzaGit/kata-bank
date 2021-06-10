package com.bank.bdd;

import com.bank.Account;
import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BDDStepDefinitions implements En {
    private LocalDate now = LocalDate.now();
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private Account account;

    public BDDStepDefinitions() {
        Given("^I have an empty account$", () -> {
            account = new Account();
        });

        Given("^I have an deposit operation of (\\d+) Euros$", (Integer amount) -> {
            account.deposit(new BigDecimal(amount), now);
        });

        Given("^I have an withdraw operation of (\\d+) Euros$", (Integer amount) -> {
            account.withdraw(new BigDecimal(amount), now);
        });

        When("^I deposit (\\d+) Euros$", (Integer amount) -> {
            account.deposit(new BigDecimal(amount), now);
        });

        When("^I withdraw (\\d+) Euros$", (Integer amount) -> {
            account.withdraw(new BigDecimal(amount), now);
        });

        Then("^My balance should be (\\d+) Euros$", (Integer amount) -> {
            Assertions.assertEquals(new BigDecimal(amount), account.getBalance());
        });
    }

}
