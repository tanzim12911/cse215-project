/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csv;

/**
 *
 * @author hellm
 */
public class CsvRecord {

    private int id;
    private String[] data;

    public CsvRecord() {
    }

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

    /**
     *
     * @return ID, name, age, email
     */
    @Override
    public String toString() throws NullPointerException {
        String name = null;
        String age = null;
        String email = null;
        try{
            name = this.data[0];
            age = this.data[1];
            email = this.data[2];
            return  name + " " + age + " " + email;
        }catch(NullPointerException e){
            System.out.println("Record destroyed");
        }
        return "";
    }
   
}
