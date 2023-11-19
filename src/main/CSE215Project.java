/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.src.Communicator;
import java.io.IOException;
import java.util.Scanner;
import controller.src.Client;

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
        if(cl != null){
            System.out.println(cl);
        }else{
            System.out.println("Wrong credentials. Please try again");
        }
    }

}
