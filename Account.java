/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

/**
 * A class for account, could be a saving account or a checking.
 * @author Nicolas Nguyen
 */
public class Account {
    private char type;
    private double balance;
    
    /**
     * Default constructor
     */
    public Account() {
        this.type = 'c';
        this.balance = 0;      
    }

    /**
     * Constructor with two parameters
     * @param type type of the account(balance or saving account)
     * @param balance the balance of the account
     */
    public Account(char type, double balance) {
        this.type = type;
        this.balance = balance;
    }
    
    /**
     * Copy constructor
     * @param account copy of the account
     */
    public Account(Account account) {           // account lowercase -> object
        this.type = account.type;               // left(copier) = right(data member being copied)
        this.balance = account.balance;
        
    }
    /**
     * To compare if two accounts are the same
     * @param account true if they are the same
     * @return True if both accounts are the same and False if not.
     */
    public boolean equals(Account account) {
        return this.type == account.type && this.balance == account.balance;
    }
    
    /**
     * A string that represents the account
     * @return the string that represents the account.
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s: %s\n", "Type", type == 'c' ? "Checking" : "Saving");
        str += String.format("%-10s: $%.2f\n", "Balance", balance);
       
       return str;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
