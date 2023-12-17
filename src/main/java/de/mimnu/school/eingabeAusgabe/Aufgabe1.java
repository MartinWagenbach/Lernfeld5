package de.mimnu.school.eingabeAusgabe;

import java.util.Scanner;

public class Aufgabe1 {
    
    	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Geben Sie eine Zahl zwischen 0 und 500 ein: ");
		
		int a = input.nextInt();
		
		System.out.println("Die eingegebene Zahl lautet: " + a);
		
		input.close();
	}
}
