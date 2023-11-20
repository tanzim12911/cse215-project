/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.src;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author jawad
 */
public class Transaction {

    private Date date;
    private String type; // The type of the transaction, such as 'W' for withdrawal, 'D' for deposit
    private double amount;
    private double balance;
    private int reciever_phone;
    private String date_local;
    private String reciever_name;
    private Client cl;

    public Transaction(String type, double amount, double balance, int reciever_phone) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.reciever_phone = reciever_phone;
        this.date = new Date();
    }

    public Transaction(String type, double amount, double balance, int reciever_phone, String date_local, Client cl, String reciever_name) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.reciever_phone = reciever_phone;
        this.date_local = date_local;
        this.reciever_name = reciever_name;
        this.cl = cl;
    }

    public String getReciever_name() {
        return reciever_name;
    }

    public String getClient_name() {
        return cl.getName();
    }

    public String getDate_local() {
        return date_local;
    }

    public int getReciever_phone() {
        return reciever_phone;
    }

    public void setReciever_phone(int reciever_phone) {
        this.reciever_phone = reciever_phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Transaction [date=" + date + ", type=" + type + ", amount=" + amount + ", balance=" + balance
                + "]";
    }

}
