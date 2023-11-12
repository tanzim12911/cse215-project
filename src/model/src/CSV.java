/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hellm
 */
public class CSV {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        CsvDatabase db = new CsvDatabase();
        CsvTable table = db.createTable("test");
        table.loadFromCsv("test");
//        table.create(new String[]{ "John Doe", "30", "john@hagu.com" });
//        table.create(new String[]{ "Bae", "2678", "bae@hagu.com" });
//        table.create(new String[]{ "Bae2", "21", "bae@hagu.com" });
//        table.create(new String[]{ "Bae3", "8", "bae@hagu.com" });
//        
//        CsvRecord johnDoeRecord = table.read(1);
//        CsvRecord janeSmithRecord = table.read(2);
        
//        System.out.println(johnDoeRecord);
        
        
//        table.update(1, new String[]{"John Doe", "30", "john.doe@example.com"});
//        
//        
//        table.delete(2);
//        
//        
//        table.create(new String[]{ "Bae", "28", "bae@hagu.com" });
//        table.create(new String[]{ "Bae", "28", "bae@hagu.com" });
//        table.create(new String[]{ "Bae", "28", "bae@hagu.com" });
//        
//        
//        System.out.println(janeSmithRecord);
        
        
        
        ArrayList<CsvRecord> allRecords = table.readAll();
        
        for(int k=0; k<allRecords.size(); k++){
            CsvRecord rec = allRecords.get(k);
            System.out.println(rec);
        }
    }
    
}
