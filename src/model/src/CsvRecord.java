/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.src;

/**
 * Deals with records
 *
 * @author hellm
 */
public class CsvRecord {

    private int id;

    public void setId(int id) {
        this.id = id;
    }
    private String[] data;

    public CsvRecord(int id, String[] data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

//    /**
//     *
//     * @return ID, name, age, email
//     */
//    @Override
//    public String toString() throws NullPointerException {
//        String name = null;
//        int phoneNum;
//        double balance;
//        String pin;
//        try {
//            name = this.data[0];
//            phoneNum = Integer.parseInt(this.data[1]);
//            pin = this.data[2];
//            balance = Double.parseDouble(this.data[3]);
//            return "Client [name=" + name + ", phoneNum=" + phoneNum + ", pin=" + pin + ", balance=" + balance + "]";
//        } catch (NullPointerException e) {
//            System.out.println("Record destroyed");
//        }
//        return "";
//    }
}
