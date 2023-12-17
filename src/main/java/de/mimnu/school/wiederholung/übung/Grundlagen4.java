package de.mimnu.school.wiederholung.übung;

import java.util.Random;

public class Grundlagen4 {
    
    public static void main(String args[]) {
		//Aufgabe a
		int a = new Random().nextInt();
		
		System.out.println(a);
		
		//Aufgabe b
		int b = new Random().nextInt(1 + 1);
		
		System.out.println("Die Münze hat den Wert " + b);
		
		//Aufgabe c
		int c = new Random().nextInt(1, 6 + 1);
		
		System.out.println("Der Würfel hat den Wert " + c);
	}
}
