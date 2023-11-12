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

/**
 *
 * @author hellm
 */
public class Communicator extends CsvDatabase {

    private CsvTable table;

    public Communicator() throws IOException {
        CsvDatabase db = new CsvDatabase();
        this.table = db.createTable("test");
        table.loadFromCsv();
    }

    public void saveClient(Client client) throws IOException {
        String[] s = new String[]{client.getName(), "" + client.getPhoneNum(), client.getPin(), "" + client.getBalance()};
        table.create(s);
    }
    public void updateClient(int id, Client client) throws IOException {
        String[] s = new String[]{client.getName(), "" + client.getPhoneNum(), client.getPin(), "" + client.getBalance()};
        table.update(id, s);
    }

    public void readClients() {
        ArrayList<CsvRecord> allRecords = table.readAll();
        for (int k = 0; k < allRecords.size(); k++) {
            CsvRecord rec = allRecords.get(k);
            for(int i=0; i<rec.getData().length; i++){
                System.out.print(rec.getData()[i] + " ");
            }
            System.out.println();
        }

        
    }

}
