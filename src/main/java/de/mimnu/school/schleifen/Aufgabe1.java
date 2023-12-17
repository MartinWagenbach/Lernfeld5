package de.mimnu.school.schleifen;

public class Aufgabe1 {
    
    public static void main(String args[]) {
		//Initialisierung der Variablen.
		int result = 0;
		
		//For-Schleife
		for(int i = 1; i <= 1000; i++) {
			result += i;
			
			if(i != 1000) {
				System.out.println(result);
			}
		}
		
		System.out.println("For-Schleife: " + result);
		
		result = 0;
		
		//While-Schleife
		int counter = 1;
		
		while(counter <= 1000) {
			result += counter;

			if(counter != 1000) {
				System.out.println(result);
			}
			
			counter++;
		}
		
		System.out.println("While-Schleife: " + result);
		
		result = 0; counter = 1;
		
		//Do-While-Schleife
		do {
			result += counter;

			if(counter != 1000) {
				System.out.println(result);
			}
			
			counter++;
		} while(counter <= 1000);
		
		System.out.println("Do-While-Schleife: " + result);
	}
}
