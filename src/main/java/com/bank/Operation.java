package com.bank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.bank.OperationType.DEPOSIT;
import static com.bank.OperationType.WITHDRAWAL;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Operation {


    private Account account;
    private OperationType type;
    private BigDecimal amount;
    private LocalDate date;

    public static Operation deposit(Account account, BigDecimal amount, LocalDate date) {
        return new Operation(account, DEPOSIT, amount, date);
    }

    public static Operation withdrawal(Account account, BigDecimal amount, LocalDate date) {
        return new Operation(account, WITHDRAWAL, amount, date);
    }

    @Override
    public String toString() {
        return type + " " +
                date.format(DateTimeFormatter.ISO_DATE) + " " +
                amount + " ";
    }
}