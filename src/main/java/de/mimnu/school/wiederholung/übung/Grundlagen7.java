package de.mimnu.school.wiederholung.übung;

import java.util.Scanner;

public class Grundlagen7 {
    
    	public static void main(String args[]) {
		//Aufgabe a
		double dm = 9876.54;

		System.out.println(dm / 1.95583);
		
		//Aufgabe b
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie einen Betrag in D-Mark ein, welcher in Euro umgerechnet werden soll:");
		
		double dMark = input.nextDouble();
		
		System.out.println(dMark + " DM sind " + dMark / 1.95583 + " Euro.");
		
		input.close();
	}
}
