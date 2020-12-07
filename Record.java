/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.util.Date;

/**
 * A class for a ATM operation record
 * @author Nicolas Nguyen
 */
public class Record {
    private String operation;
    private double amount;
    private Date date;
    private String atmId;
    
    /**
     * Default constructor
     */
    public Record() {
        this.operation = null;
        this.amount = 0;
        this.date = null;          
        this.atmId = null;
    }

    /**
     * Constructor with three parameters
     * @param operation the atm operation to be done
     * @param amount the amount of money
     * @param atmId the ID of the atm used
     */
    public Record(String operation, double amount, String atmId) {
        this.operation = operation;
        this.amount = amount;
        this.date = new Date();
        this.atmId = atmId;
    }
    
    /**
     * Copy constructor
     * @param record the record to be copied
     */
    public Record(Record record) {
        this.operation = record.operation;
        this.amount = record.amount;
        this.date = record.date;
        this.atmId = record.atmId;
    }
    
    /**
     * To check if two record are the same or not.
     * @param record the record to be compared with
     * @return True if both records are the same and false if not.
     */
    public boolean equals (Record record) {
        return this.operation.equals(record.operation) &&
                this.amount == record.amount &&
                this.date.equals(record.date) &&
                this.atmId.equals(record.atmId);
    }

    /**
     * A string that represents the record
     * @return the string that represents a record
     */
    @Override
    public String toString() {
        String str = "";
        str += String.format("%-10s: %s\n", "Operation", operation);
        str += String.format("%-10s: $%.2f\n", "Amount", amount);
        str += String.format("%-10s: %s\n", "Date", date);
        str += String.format("%-10s: %s\n", "ATM ID", atmId);       
        return str;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }
}
