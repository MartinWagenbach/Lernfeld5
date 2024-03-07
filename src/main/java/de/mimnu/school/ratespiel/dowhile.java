package de.mimnu.school.ratespiel;

import java.util.Random;
import java.util.Scanner;

public class dowhile {
    public static void main(String[] args) {
        // Zufallszahl zwischen 1 und 100 generieren
        Random random = new Random();
        int gesuchteZahl = random.nextInt(100) + 1;

        // Scanner für Benutzereingabe initialisieren
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Willkommen beim Zahlerraten-Spiel!");
        System.out.println("Versuche die Zahl zwischen 1 und 100 zu erraten.");
        
        int versuche = 0;
        int benutzerEingabe;
        
        do {
            System.out.print("Gib deinen Tipp ein: ");
            
            benutzerEingabe = scanner.nextInt();
            versuche++;
            
            if (benutzerEingabe < gesuchteZahl) {
                System.out.println("Die gesuchte Zahl ist größer!");
            } else if(benutzerEingabe > gesuchteZahl){
                System.out.println("Die gesuchte Zahl ist kleiner!");
            }
        } while(benutzerEingabe != gesuchteZahl);
        
        System.out.println("Du hast gewonnen!");
        System.out.println("Du hast "+versuche+" Versuche gebraucht.");
        
        scanner.close();
    }
}