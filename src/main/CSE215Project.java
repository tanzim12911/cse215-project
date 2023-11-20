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
        new WelcomePage().setVisible(true);
        Scanner input = new Scanner(System.in);
        Communicator talk = new Communicator();

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
