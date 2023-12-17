package de.mimnu.school.wiederholung.übung;

public class Grundlagen6 {
    
    public static void main(String args[]) {
		//Aufgabe a und b
		int a = 3, b = 5;
		
		System.out.println(a + " und " + b);
		
		a += b;
		b = a - b;
		a -= b;
		
		System.out.println(a + " und " + b);
	}
}
