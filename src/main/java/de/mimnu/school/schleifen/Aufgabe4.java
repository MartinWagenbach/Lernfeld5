package de.mimnu.school.schleifen;

public class Aufgabe4 {
    
    public static void main(String args[]) {
		//Initialisierung der Variablen.
		int result = 0;
		
		//For-Schleife
		for(int i = 1000; i <= 1500; i++) {
			if(i % 2 != 0) {
				result += i;

				if(i != 1500) {
					System.out.println(result);
				}
			}
		}
		
		System.out.println("For-Schleife: " + result);
		
		result = 0;
		
		//While-Schleife
		int counter = 1000;
		
		while(counter <= 1500) {
			if(counter % 2 != 0) {
				result += counter;

				if(counter != 1500) {
					System.out.println(result);
				}
			}
			
			counter++;
		}
		
		System.out.println("While-Schleife: " + result);
		
		result = 0; counter = 1000;
		
		//Do-While-Schleife
		do {
			if(counter % 2 != 0) {
				result += counter;

				if(counter != 1500) {
					System.out.println(result);
				}
			}
			
			counter++;
		} while(counter <= 1500);
		
		System.out.println("Do-While-Schleife: " + result);
	}
}
