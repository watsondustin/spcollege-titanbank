/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

/**
 *
 * @author Dustin
 */
public class BankAccount {
    private enum AccountType{
      SAVINGS,
      CHECKING
    }
    
    private Customer customer;
    private double balance;
    private AccountType typeOfAccount;
    
    public BankAccount(Customer customer, double startingBalance, AccountType typeOfAccount){
        this.customer = customer;
        this.balance = startingBalance;
        this.typeOfAccount = typeOfAccount;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    public double getBalance(){
        return this.balance;
    }
    public boolean hasSufficientFunds(double amt){
        return this.balance >= amt;
    }
    public void withdraw(double amt) throws InsufficientFundsException{
        if(hasSufficientFunds(amt))
            this.balance -= amt;
        else
            throw new InsufficientFundsException();
    }
    public void deposit(double amt){
        this.balance += amt;
    }
}
