/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.util.Scanner;

/**
 * Class of an ATM.
 * @author Nicolas Nguyen
 */
public class AutomatedTellerMachine {
   private String atmID;
   private Account account;
   private User user;
   private static int nextID;

    /**
     * Default constructor
     */
    public AutomatedTellerMachine() {
       this.atmID = String.format("06d", nextID++);
       this.user = null;
       this.account = null;
    }

    /**
     * Constructor with one parameter
     * @param atmID the atmID of the ATM.
     */
    public AutomatedTellerMachine(String atmID) {
        this.atmID = atmID;
        this.user = null;
        this.account = null;
    }
    
    /**
     * Copy constructor
     * @param automatedTellerMachine the ATM object to copy
     */ 
    public AutomatedTellerMachine(AutomatedTellerMachine automatedTellerMachine) {
        this.atmID = automatedTellerMachine.atmID;
        this.user = new User(automatedTellerMachine.user);
        this.account = new Account(automatedTellerMachine.account);
    }
    
    /**
     * The pipeline of the ATM if someone wants to use it
     */
    public void pipeline() {
        printWelcome();
        readUserId();
        if (user == null) 
            System.exit(1);   
        if (!inputPassword())
            System.exit(2);        
        chooseAccount();
        do {
            int oper = chooseOperation();
            switch (oper) {
                case 1: 
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                default:
                    displayBalance();
            }
        } while(doesContinue());
        printGoodbye();
    }
       
    /**
     * To print a welcome message at the very beginning.
     */
    public void printWelcome() {
        System.out.println("Welcome to use our ATM");
    }
    
    /**
     * To ask the user to input the user id, if the id exists, then return the
     * user object, else will shut down the entire process.
     *  public User readUserId() { 
     */
    public void readUserId() { 
        Scanner console = new Scanner(System.in);      
        System.out.println("Please enter your user ID");
        String inputId = console.next();
        for (int i = 0; i < Bank.getUsers().size(); i++) 
            if (inputId.equals(Bank.getUsers().get(i).getUserId())) {
                user = Bank.getUsers().get(i);
                return;
            }
        user = null;
        
    }
    
    /**
     * To ask the user to input the password. The user has three times to
     * give the right password, if the user failed 3 times, then the process will
     * be shut down.
     * @return if the password is correct
     */
    public boolean inputPassword() { 
        Scanner console = new Scanner(System.in);
        int maxTry = 3;
        
        for (int i = 0; i < maxTry; i++) {
            System.out.println("Please enter your user password");
            String password = console.next();
            if (user.getPassword().equals(password))
                return true;
            System.out.println("Your password is wrong");
        } 
        System.out.println("You input a passwrod wrong for 3 times");
        return false;
    }

    /**
     * To ask the user to choose the account, could be
     * 1. checking account
     * 2. saving account
     * public Account chooseAccount(User user) { 
     */
    public void chooseAccount() {
        Scanner console = new Scanner(System.in);
            
        System.out.println("Please choose the account you want to operate with"
                + "\n\t1. Checking account"
                + "\n\t2. Saving account");
        int accountChoice = console.nextInt();
        
        account = accountChoice == 1 ? user.getCheckingAccount(): user.getSavingAccount();
 
    }  

    /**
     * To ask the user to choose the operation, could be:
     * 1. withdraw
     * 2. deposit
     * 3. display balance
     * @return the operation the user select
     */
    public int chooseOperation() {
        Scanner console = new Scanner(System.in);
        System.out.println("Please choose the account you want to operate with"
                + "\n\t1. Withdraw"
                + "\n\t2. Deposit"
                + "\n\t3. Display balance");  
        int operation = console.nextInt();  
        return operation;
    }

    /**
     * To withdraw from the ATM
     * @return true if withdraw successfully
     */
    public boolean withdraw() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("How much do you want to withdraw? ");
        double amount = console.nextDouble();
        if (account.getBalance() < amount) {
            System.out.println("Sorry, you don't have enough balance.");
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdraw successfully");
        user.getHistory().add(new Record("withdraw", amount, atmID));
        return true;
    }
    
    /**
     * To withdraw from the ATM
     * @return true if withdraw successfully
     *  public boolean deposit(Account account, User user) {
     */
    public boolean deposit() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("How much do you want to deposit? ");
        double amount = console.nextDouble();
        
        account.setBalance(account.getBalance() + amount);
        System.out.println("deposit successfully");
        user.getHistory().add(new Record("deposit", amount, atmID));
        return true;
    }
    
    /**
     * To display the balance of the account
     * public void displayBalance(Account account) {
     */
    public void displayBalance() {
        System.out.printf("Your current balance is $%.2f\n", account.getBalance());
    }
    
    /**
     * Asks the user if he/she wants to do another operation
     * @return true if the user wants to do another operation
     */
    public boolean doesContinue() {
        Scanner console = new Scanner(System.in);   
        System.out.println("Do you want to do another operation? ");
        System.out.println("0. No");
        System.out.println("1. Yes");
        int answer = console.nextInt();
        return answer == 1;
    }
    
    /**
     * To print a goodbye message
     */
    public void printGoodbye() {
        System.out.println("Thank you for using our ATM, Goodbye!");
        user = null;
        account = null;  
    }

    public boolean equals(AutomatedTellerMachine automatedTellerMachine) {
        return this.atmID.equals(automatedTellerMachine.atmID);
    }

    @Override
    public String toString() {
        return String.format("-10s: %s", "ATM ID", atmID);
    }

    public String getAtmID() {
        return atmID;
    }

    public void setAtmID(String atmID) {
        this.atmID = atmID;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        AutomatedTellerMachine.nextID = nextID;
    }
}
