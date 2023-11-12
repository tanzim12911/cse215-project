/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.src;


import java.io.IOException;
import java.util.ArrayList;

/**
 * Test File 
 * Deals with all the files
 * @author hellm
 */
public class CsvDatabase {
    private ArrayList<CsvTable> tables;

    public CsvDatabase() {
        this.tables = new ArrayList<>();
    }
    
    public CsvTable createTable(String tbName) throws IOException{
        CsvTable t = new CsvTable(tbName);
        tables.add(t);
        return t;
    }
    
    public CsvTable getTable(String tbName){
        for(int i=0; i<tables.size(); i++){
            CsvTable tb = tables.get(i);
            
            if(tb.getTableName().equals(tbName)){
                return tb;
            }
        }
        return null;
    }   
    
    public void dropTable(String tbName){
        CsvTable tbToRemove = null;
        
        for(int i=0; i<tables.size(); i++){
            CsvTable getTb = tables.get(i);
            
            if(getTb.getTableName().equals(tbName)){
                tbToRemove = getTb;
            }
        }
        
        if(tbToRemove != null){
            tables.remove(tbToRemove);
        }
    }
}
