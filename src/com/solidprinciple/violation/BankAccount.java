package com.solidprinciple.violation;

public interface BankAccount {
    public void name(String name);
    public void accountNumber(long number);
    void creditAmount(long amount);
    void debitAmount(long amount);
}
