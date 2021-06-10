package com.bank;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.bank.OperationType.DEPOSIT;

@Getter
public class Account {
    private List<Operation> operations = new ArrayList<>();

    public Account() {

    }

    public BigDecimal getBalance() {
        BigDecimal currentBalance = BigDecimal.ZERO;
        for (Operation operation : operations) {
            currentBalance = (operation.getType() == DEPOSIT) ? currentBalance.add(operation.getAmount()) : currentBalance.subtract(operation.getAmount());
        }
        return currentBalance;
    }

    public void deposit(BigDecimal amount, LocalDate date) {
        operations.add(Operation.deposit(this, amount, date));
    }

    public void withdraw(BigDecimal amount, LocalDate date) {
        operations.add(Operation.withdrawal(this, amount, date));
    }

    @Override
    public String toString() {
        String accountString = "";
        BigDecimal currentBalance = BigDecimal.ZERO;
        for (Operation operation : operations) {
            currentBalance = (operation.getType() == DEPOSIT) ? currentBalance.add(operation.getAmount()) : currentBalance.subtract(operation.getAmount());
            accountString = operation.toString() + " " + currentBalance + "\n";
        }
        return accountString;
    }

}
