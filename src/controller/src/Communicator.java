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
    private int auth_id;
    ArrayList<Client> arc;
    private CsvTable client_table;

    public Communicator() throws IOException {
        this.field_balance = 3;
        this.field_pin = 2;
        this.field_phone = 1;
        this.field_name = 0;
        this.arc = new ArrayList<>();
        CsvDatabase db = new CsvDatabase();
        this.client_table = db.createTable("client");
        client_table.loadFromCsv();
    }

    public String registerClient(Client client) throws IOException {
        Client searchClient = searchClient("", client.getPhoneNum(), false, true, false);
        if (searchClient != null) {
            return "Phone number must be unique.";
        }
        String[] s = new String[]{client.getName(), "" + client.getPhoneNum(), client.getPin(), "" + client.getBalance()};
        try {
            client_table.create(s);
            return "Registered Successfully.";
        } catch (IOException ex) {
            return "Something went wrong.. Please try again.";
        }
    }

    public Client loginClient(String name, String pin) {
        Client cl = null;
        ArrayList<CsvRecord> allRecords = client_table.readAll();
        for (int k = 0; k < allRecords.size(); k++) {
            CsvRecord rec = allRecords.get(k);
            double balance = Double.parseDouble(rec.getData()[field_balance]);
            int ph = Integer.parseInt(rec.getData()[field_phone]);
            if (pin.equalsIgnoreCase(rec.getData()[field_pin]) && name.equalsIgnoreCase(rec.getData()[field_name])) {
                auth_id = rec.getId();
                return cl = new Client(rec.getData()[field_name], ph, rec.getData()[field_pin], balance);
            }
        }
        return cl;
    }

    public boolean updateClient(Client client) throws IOException {
        String[] s = new String[]{client.getName(), "" + client.getPhoneNum(), client.getPin(), "" + client.getBalance()};
        try {
            client_table.update(auth_id, s);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean deleteClient() throws IOException {
        try {
            client_table.delete(auth_id);
            return true;
        } catch (IOException ex) {
            return false;
        }
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
    public ArrayList<Client> readAllClients() {
        ArrayList<CsvRecord> allRecords = client_table.readAll();
        for (int k = 0; k < allRecords.size(); k++) {
            CsvRecord rec = allRecords.get(k);
            double balance = Double.parseDouble(rec.getData()[field_balance]);
            int ph = Integer.parseInt(rec.getData()[field_phone]);
            arc.add(new Client(rec.getData()[field_name], ph, rec.getData()[field_pin], balance));
        }
        return arc;
    }

    public Client searchClient(String name, int phone, boolean search_name_only, boolean search_ph_only, boolean search_name_phone) {
        arc.clear();
        readAllClients();
        Client cl = null;
        for (int i = 0; i < arc.size(); i++) {
            cl = arc.get(i);
            if (search_name_only) {
                if (name.equalsIgnoreCase(cl.getName())) {
                    return cl;
                }
            } else if (search_ph_only) {
                if (phone == cl.getPhoneNum()) {
                    return cl;
                }
            } else if (search_name_phone) {
                if (name.equalsIgnoreCase(cl.getName()) && phone == cl.getPhoneNum()) {
                    return cl;
                }
            }
            cl = null;
        }
        return cl;
    }

    public ArrayList<Client> searchPossibleClient(String alphabet) {
        arc.clear();
        readAllClients();
        ArrayList<Client> possible_clients = new ArrayList<>();
        for (int i = 0; i < arc.size(); i++) {
            Client cl = arc.get(i);
            if (cl.getName().toLowerCase().startsWith(alphabet.toLowerCase())) {
                possible_clients.add(cl);
            }
        }
        return possible_clients;
    }
}
