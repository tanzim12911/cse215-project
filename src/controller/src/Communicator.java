/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.src;

import java.io.IOException;
import java.util.ArrayList;
import model.src.CsvDatabase;
import model.src.CsvTable;
import model.src.CsvRecord;
import controller.src.Client;

/**
 *
 * @author hellm
 */
public class Communicator extends CsvDatabase {

    private final int field_name;
    private final int field_phone;
    private final int field_pin;
    private final int field_balance;
    private CsvTable client_table;

    public Communicator() throws IOException {
        this.field_balance = 3;
        this.field_pin = 2;
        this.field_phone = 1;
        this.field_name = 0;
        CsvDatabase db = new CsvDatabase();
        this.client_table = db.createTable("client");
        client_table.loadFromCsv();
    }

    public boolean registerClient(Client client) throws IOException {
        String[] s = new String[]{client.getName(), "" + client.getPhoneNum(), client.getPin(), "" + client.getBalance()};
        try {
            client_table.create(s);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public void updateClient(int id, Client client) throws IOException {
        String[] s = new String[]{client.getName(), "" + client.getPhoneNum(), client.getPin(), "" + client.getBalance()};
        client_table.update(id, s);
    }

    public Client loginClient(String name, String pin) {
        Client cl = null;
        ArrayList<CsvRecord> allRecords = client_table.readAll();
        for (int k = 0; k < allRecords.size(); k++) {
            CsvRecord rec = allRecords.get(k);
            for (int i = 0; i < rec.getData().length; i++) {
                double balance = Double.parseDouble(rec.getData()[field_balance]);
                int ph = Integer.parseInt(rec.getData()[field_phone]);
                if (pin.equalsIgnoreCase(rec.getData()[field_pin]) && name.equalsIgnoreCase(rec.getData()[field_name])) {
                    return cl = new Client(rec.getData()[field_name], ph, rec.getData()[field_pin], balance);
                }
            }
        }
        return cl;
    }

//        public Client registerClient(String name, int phone) {
//        Client cl = null;
//        ArrayList<CsvRecord> allRecords = client_table.readAll();
//        for (int k = 0; k < allRecords.size(); k++) {
//            CsvRecord rec = allRecords.get(k);
//            for (int i = 0; i < rec.getData().length; i++) {
//                double balance = Double.parseDouble(rec.getData()[field_balance]);
//                int ph = Integer.parseInt(rec.getData()[field_phone]);
//                if (phone == ph && name.equalsIgnoreCase(rec.getData()[field_name])) {
//                    return cl = new Client(rec.getData()[field_name], ph, rec.getData()[field_pin], balance);
//                }
//            }
//        }
//         return cl;
//    }
//    public void readClients() {
//        int name = 0;
//        int phone = 1;
//        int pin = 2;
//        int balance = 3;
//        ArrayList<CsvRecord> allRecords = client_table.readAll();
//        for (int k = 0; k < allRecords.size(); k++) {
//            CsvRecord rec = allRecords.get(k);
//            for (int i = 0; i < rec.getData().length; i++) {
//                String datas = rec.getData()[phone];
//
//                System.out.println(datas);
//            }
//            System.out.println();
//        }
//    }
}
