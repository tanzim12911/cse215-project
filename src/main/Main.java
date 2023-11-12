/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.src.Client;
import java.io.IOException;
import controller.src.Communicator;
import java.util.Scanner;

/**
 * Main Package Will control view or GUI in future
 *
 * @author hellm
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
      
        Scanner sc = new Scanner(System.in);
//        
//        String name = sc.nextLine();
//        int phoneNum = sc.nextInt();
//        String pin = sc.next();
//        double balance = sc.nextDouble();
        
        String name = "Mir";
        int phoneNum = 999999;
        String pin = "2222";
        double balance = 22232.98;
        
        Client cl = new Client(name, phoneNum, pin, balance);
        Client cl2 = new Client(name, phoneNum, pin, balance);
        
        Communicator talk = new Communicator();
        
        talk.saveClient(cl);
        talk.saveClient(cl2);
        
        talk.readClients();
    }

}
