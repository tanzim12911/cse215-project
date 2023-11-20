/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.src.Communicator;
import java.io.IOException;
import java.util.Scanner;
import controller.src.Client;
import java.util.ArrayList;

/**
 *
 * @author tanzi
 */
public class CSE215Project {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
//        new WelcomePage().setVisible(true);
        Scanner input = new Scanner(System.in);
        Communicator talk = new Communicator();

//        System.out.println("Register now: ");
//        String name = input.nextLine();
//         int phoneNum = 0;
//        try {
//            phoneNum = Integer.parseInt(input.nextLine());
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        String pin = input.next();
//        double balance = input.nextDouble();
//        
//        Client details = new controller.src.Client(name, phoneNum, pin, balance);
//        talk.registerClient(details);
        /*
        IDK why login works separetly, input issue maybe, bt it works
        First comment out login portion, then try register
        THen comment out register portion, try login
         */
        System.out.println("Login now: ");
        String enter_name = input.nextLine();

        String enter_pin = input.next();

        Client cl = talk.loginClient(enter_name, enter_pin);
        if (cl != null) {
            System.out.println(cl);
        } else {
            System.out.println("Wrong credentials. Please try again");
        }
        
//      Do Operations with the client instance got from login
        System.out.println("Add amount: ");
        double am = input.nextDouble();
        double new_balance = am + cl.getBalance(); 
        System.out.println("Remove amount/Deposit: ");
        double am2 = input.nextDouble();
        new_balance -= am2;
        cl.setBalance(new_balance);
//        After successful operations pass the instance to updateCLient()
        talk.updateClient(cl);

//      Read All the clients
        ArrayList<Client> readAllClients = talk.readAllClients();

        for (Client client : readAllClients) {
            System.out.println(client);
        }
        
//        Search Clients
        
        Client searchClient = talk.searchClient("jawad", 12345678, false, false, true);
        System.out.println("Found : " + searchClient);

//        Search client with similar names
        ArrayList<Client> searchPossibleClient = talk.searchPossibleClient("m");
        System.out.println("Found " + searchPossibleClient.size() + " matches: ");
        for(int i = 0; i<searchPossibleClient.size();i++){
            System.out.println(searchPossibleClient.get(i));
        }
    }

}
