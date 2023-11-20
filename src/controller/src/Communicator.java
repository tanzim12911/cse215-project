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
import controller.src.Transaction;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hellm
 */
public class Communicator extends CsvDatabase {

    private final int field_name;
    private final int field_phone;
    private final int field_pin;
    private final int field_balance;
    private final int field_type;
    private final int field_amount;
    private final int field_left_balance;
    private final int field_receiver_phone;
    private final int field_date;
    private int auth_id;
    ArrayList<Client> arc;
    ArrayList<Transaction> transaction;
    private final CsvTable client_table;
    private final CsvTable transaction_table;
    private Client cl;

    /**
     * Registers all the column, initializes db, creates table, loads previous
     * data, initializes clients and array list
     *
     * @throws IOException
     */
    public Communicator() throws IOException {
//        CSV Columns for transaction
        this.field_date = 4;
        this.field_receiver_phone = 3;
        this.field_left_balance = 2;
        this.field_amount = 1;
        this.field_type = 0;
//        CSV Columns for client
        this.field_balance = 3;
        this.field_pin = 2;
        this.field_phone = 1;
        this.field_name = 0;

        this.arc = new ArrayList<>();
        this.transaction = new ArrayList<>();

        cl = null;

        CsvDatabase db = new CsvDatabase();
        this.client_table = db.createTable("client");
        this.transaction_table = db.createTable("transaction");

        client_table.loadFromCsv();
    }

    /**
     *
     * @param client
     * @return Validation String
     * @throws IOException
     */
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

    /**
     *
     * @param name
     * @param pin
     * @return instance of client
     */
    public Client loginClient(String name, String pin) {
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

    /**
     *
     * @param client
     * @return true for successful update, false for unsuccessful update
     * @throws IOException
     */
    public boolean updateClient(Client client) throws IOException {
        String[] s = new String[]{client.getName(), "" + client.getPhoneNum(), client.getPin(), "" + client.getBalance()};
        try {
            client_table.update(auth_id, s);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     *
     * @return true or false based on attempt
     * @throws IOException
     */
    public boolean deleteClient() throws IOException {
        try {
            client_table.delete(auth_id);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     *
     * @return array list of clients
     */
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

    /**
     *
     * @param name
     * @param phone
     * @param search_name_only
     * @param search_ph_only
     * @param search_name_phone
     * @return instance of searched client
     */
    public Client searchClient(String name, int phone, boolean search_name_only, boolean search_ph_only, boolean search_name_phone) {
        arc.clear();
        readAllClients();
        Client search_client = null;
        for (int i = 0; i < arc.size(); i++) {
            cl = arc.get(i);
            if (search_name_only) {
                if (search_client != null && name.equalsIgnoreCase(search_client.getName())) {
                    return search_client;
                }
            } else if (search_ph_only) {
                if (search_client != null && phone == search_client.getPhoneNum()) {
                    return search_client;
                }
            } else if (search_name_phone) {
                if (search_client != null && name.equalsIgnoreCase(search_client.getName()) && phone == cl.getPhoneNum()) {
                    return search_client;
                }
            }
            search_client = null;
        }
        return search_client;
    }

    /**
     *
     * @param alphabet
     * @return list containing the clients with initial of given alphabet or
     * word
     */
    public ArrayList<Client> searchPossibleClient(String alphabet) {
        arc.clear();
        readAllClients();
        ArrayList<Client> possible_clients = new ArrayList<>();
        for (int i = 0; i < arc.size(); i++) {
            Client possible_cl = arc.get(i);
            if (possible_cl.getName().toLowerCase().startsWith(alphabet.toLowerCase())) {
                possible_clients.add(possible_cl);
            }
        }
        return possible_clients;
    }

    /**
     *
     * @param transaction
     * @throws IOException
     */
    public void logTransaction(Transaction transaction) throws IOException {
        String[] s = new String[]{transaction.getType(), transaction.getAmount() + "", transaction.getBalance() + "", transaction.getReciever_phone() + "", transaction.getDate() + ""};
        this.transaction_table.create(s);
    }

    /**
     *
     * @return list of all transactions made by all users
     */
    public ArrayList<Transaction> readAllTransactions() {
        ArrayList<CsvRecord> allRecords = transaction_table.readAll();
        for (int k = 0; k < allRecords.size(); k++) {
            CsvRecord rec = allRecords.get(k);
            double balance = Double.parseDouble(rec.getData()[field_left_balance]);
            double amount = Double.parseDouble(rec.getData()[field_amount]);
            int ph = Integer.parseInt(rec.getData()[field_receiver_phone]);
            String reciever_name = "Not registered";
            Client reciever = searchClient("", ph, false, true, false);
            if (reciever != null) {
                reciever_name = reciever.getName();
            }
            String dateString = rec.getData()[field_date];

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");

            LocalDateTime dateTime = LocalDateTime.parse(dateString, dtf);

            DateTimeFormatter format_output = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm:ss a");
            String date_string = dateTime.format(format_output);

            transaction.add(new Transaction(rec.getData()[field_type], amount, balance, ph, date_string, cl, reciever_name));
        }
        return transaction;
    }
}
