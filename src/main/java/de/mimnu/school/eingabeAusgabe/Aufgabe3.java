package de.mimnu.school.eingabeAusgabe;

import java.util.Scanner;

public class Aufgabe3 {
    
    public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Geben Sie eine Nachricht ein: ");
		
		String a = input.nextLine();
		
		System.out.println("Die eingegebene Nachricht lautet: " + a);
		
		input.close();
	}
}
