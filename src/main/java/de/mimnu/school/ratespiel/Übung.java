package de.mimnu.school.ratespiel;

import java.util.Random;
import java.util.Scanner;

public class Übung {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int random = new Random().nextInt(100) + 1;

        int guessedNumber = -1;

        System.out.print("Hallo! Errate eine Zahl zwischen 1 und 100: ");

        do {
            guessedNumber = input.nextInt();

            if(random == guessedNumber) {
                System.out.println("Du hast Gewonnen.");
            } else if(random > guessedNumber) {
                System.out.println("Die gesuchte Zahl ist größer.");
            } else if(random < guessedNumber) {
                System.out.println("Die gesuchte Zahl ist kleiner.");
            }
        } while(random != guessedNumber);

        input.close();
    }
}
