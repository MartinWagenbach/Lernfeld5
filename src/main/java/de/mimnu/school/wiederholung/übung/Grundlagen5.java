package de.mimnu.school.wiederholung.übung;

public class Grundlagen5 {
    
    public static void main(String args[]) {
		/*
		 * Aufgabe a
		 * 
		 * Ein Boolean ist ein Wahrheitswert, welcher entweder true oder false ist.
		 * Sie eignen sich um Bedingungen zu testen.
		 */
		
		//Aufgabe b
		int a = 1, b = 0;
		boolean bool = true;
		
		do {
			if(a <= 1000) {
				if(a % 3 == 0) {
					b += a;
					
					System.out.println("Ergebnis: " + b);
				}
				
				a++;
			} else {
				bool = false;
			}
		} while(bool);
	}
}
