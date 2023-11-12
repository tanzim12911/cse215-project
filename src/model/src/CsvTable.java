/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//import java.util.List;

/**
 *
 * @author hellm
 */
public class CsvTable {

    private String tableName;
    private ArrayList<CsvRecord> records;
    private final File fl;

    public CsvTable(String tableName) {
        this.tableName = tableName;
        this.records = new ArrayList<>();
        this.fl = new File(System.getProperty("user.dir") + "/src/resources/" + tableName + ".csv");
    }

    public void create(String[] data) throws IOException {
        int nextID = getNextId();

        CsvRecord newRecord = new CsvRecord(nextID, data);

        records.add(newRecord);
        saveToCsv();
    }

    public CsvRecord read(int id) {
        for (int i = 0; i < records.size(); i++) {
            CsvRecord record = records.get(i);

            if (record.getId() == id) {
                return record;
            }
        }
        return null;
    }

    public ArrayList<CsvRecord> readAll() {
        return records;
    }

    public void update(int id, String[] newData) throws IOException {
        CsvRecord existingRec = read(id);
        if (existingRec != null) {
            existingRec.setData(newData);
        }
        saveToCsv();

    }

    public void delete(int id) throws IOException {
//        CsvRecord recToRemove = null;

        for (int i = 0; i < records.size(); i++) {
            CsvRecord record = records.get(i);

            if (record.getId() == id) {
                records.remove(record);
                record.setData(null);
//                System.out.println(record.getId());
                break;
            }
        }

        saveToCsv();
    }

    private int getNextId() {
        int id = 0;

        for (int i = 0; i < records.size(); i++) {
            CsvRecord record = records.get(i);
            if (record.getId() > id) {
                id = record.getId();
            }
        }
        return id + 1;
    }

    private void saveToCsv() throws IOException {
        try (FileWriter writer = new FileWriter(this.fl)) {
            for (int i = 0; i < records.size(); i++) {
                CsvRecord record = records.get(i);
                writer.write(record.getId() + ", ");
                for (int k = 0; k < record.getData().length; k++) {
                    writer.write(record.getData()[k]);
                    if (k != record.getData().length - 1) {
                        writer.write(", ");
                    }
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromCsv(String tableName) throws IOException{
//        try (Scanner scanner = new Scanner(fl)) {
//            while (scanner.hasNextLine()) {
//                List<String> lineData = Arrays.asList(scanner.nextLine().split(", "));
//                for(int i=0; i<lineData.size(); i++){
//                    System.out.print(lineData.get(i) + "  sp ");
//                }
////                int id = Integer.parseInt(parts[0]);
////                records.add(new CsvRecord(id, parts));
//            }
//            scanner.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        try (FileReader fr = new FileReader(this.fl)) {
            BufferedReader rd = new BufferedReader(fr);
            while (true) {
                String line = rd.readLine();
                if (line == null) {
                    break;
                }
                String[] attributes = line.split(", ");
                int id = Integer.parseInt(attributes[0]);
                String[] data = Arrays.copyOfRange(attributes, 1, attributes.length);
                records.add(new CsvRecord(id, data));
            }
            rd.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public String getTableName() {

        return tableName;
    }
}
