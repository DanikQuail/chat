package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
        boolean konecaplikace = true;
	    String jmeno;
        String zprava;

        System.out.println("----------------");
        System.out.println("Zadej !konec pro ukončení");
        System.out.println("----------------");
        System.out.println("Zadej své jméno:");
        System.out.println("----------------");
        jmeno = sc.nextLine();


        try {
            BufferedReader br = new BufferedReader(new FileReader("chat.txt"));
            System.out.println("----------------");
            System.out.println("HISTORIE CHATU :");
            System.out.println("----------------");
            String radky = br.readLine();
                while (radky != null) {
                    radky = br.readLine();
                    System.out.println(radky);
                    System.out.println("----------------");
                }
            System.out.println("KONEC CHATU");
            System.out.println("----------------");

            br.close();
        } catch (IOException e) {
            System.out.println("Nemáš žádné zprávy");
        }
        System.out.println(jmeno + ", zadej zprávu: ");
        System.out.println("----------------");

        while (konecaplikace) {
            zprava = sc.nextLine();
            if (zprava.equals("!konec")) {
                return;
            }
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("chat.txt", true));
                bw.write(jmeno + ": " + zprava);
                bw.newLine();
                bw.close();
            }
            catch (IOException e) {
                System.out.println("AHA");
            }
        }
    }
}


