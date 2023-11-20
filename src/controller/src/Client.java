package controller.src;

import java.util.ArrayList;

/**
 * Deals with client
 *
 * @author jawad
 */
public class Client {

    private String name;
    private int phoneNum;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactions;
    private int id;
    
    public Client(String name, int phoneNum, String pin, double balance) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return this;
    }

    public void withdraw(double amount) {
        balance -= amount;
//        transactions.add(new Transaction("Withdraw", amount, balance, id, ));
    }
    public void deposit(double amount) {
        balance += amount;
//        transactions.add(new Transaction("Deposit", amount, balance, name));
    }

    /**
     *
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Client name = " + name + ", phoneNum = " + phoneNum + ", pin = " + pin + ", balance = " + balance + " ";
    }

}
