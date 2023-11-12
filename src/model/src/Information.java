/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.src;

import java.io.IOException;


/**
 * Test File
 * @author hellm
 */
public class Information extends CsvTable {
    private int id;
    private String[] data;

    public Information(String tableName) throws IOException {
        super(tableName);
    }
    
    public String whereId(int id){
        CsvRecord rec = read(id);
        return rec.toString();
    }
    
    
}
