package de.mimnu.school.eingabeAusgabe;

import java.util.Scanner;

public class Aufgabe2 {
    
    	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Geben Sie eine Kommazahl zwischen 0,0 und 500,0 ein: ");
		
		float a = input.nextFloat();
		
		System.out.println("Die eingegebene Zahl lautet: " + a);
		
		input.close();
	}
}
