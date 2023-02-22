package com.hidetora;

import java.util.logging.Logger;

public class BankAccount {
    Logger logger = Logger.getLogger(BankAccount.class.getName());
    private double balance;
    private double minimumBalance;
    private boolean isActivate = true;

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    private String holderName;

    public BankAccount(double balance, double minimumBalance) {
        this.minimumBalance = minimumBalance;
        this.balance = balance;
    }

    public BankAccount(double balance, double minimumBalance, boolean isActivate) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
        this.isActivate = isActivate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double withdraw(double amount) throws RuntimeException {
        if (balance - amount < minimumBalance) {
            logger.info("Insufficient funds");
            throw new RuntimeException("Insufficient funds");
        }
        balance -= amount;
        return amount;
    }

    public double deposit(double amount) {
        return balance += amount;
    }

    public boolean isActivate() {
        return isActivate;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
    }
}
