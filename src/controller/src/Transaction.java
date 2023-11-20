/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.src;

/**
 *
 * @author hellm
 */
import java.util.Date;

public class Transaction {

    private Date date;
    private String type; // The type of the transaction, such as 'W' for withdrawal, 'D' for deposit
    private double amount;
    private double balance;
    private int sender_id;
    private int reciever_phone;

    Transaction(String type, double amount, double balance, int sender_id, int reciever_phone) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.sender_id = sender_id;
        this.reciever_phone = reciever_phone;
        this.date = new Date();
    }

    
    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
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
