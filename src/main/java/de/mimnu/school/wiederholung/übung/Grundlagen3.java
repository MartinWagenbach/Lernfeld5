package de.mimnu.school.wiederholung.übung;

public class Grundlagen3 {
    
    public static void main(String args[]) {
		//Aufgabe a
		int sum = 0;
		
		//For-Schleife
		for(int i = 1; i <= 100; i++) {
			sum = i*i;
			
			if(i != 100) {
				System.out.println(sum);
			}
		}
		
		System.out.println("For-Schleife: " + sum);
		
		sum = 0;
		
		//While-Schleife
		int counter = 1;
		
		while(counter <= 100) {
			sum = counter * counter;
			
			if(counter != 100) {
				System.out.println(sum);
			}
			
			counter++;
		}
		
		System.out.println("While-Schleife: " + sum);
		
		sum = 0; counter = 1;
		
		//Do-While-Schleife
		do {
			sum = counter * counter;
			
			if(counter != 100) {
				System.out.println(sum);
			}
			
			counter++;
		} while(counter <= 100);
		
		System.out.println("Do-While-Schleife: " + sum);
		
		/*
		 * Aufgabe b
		 * 
		 * Die Do-While-Schleife, ist die einzige Schleifenart, bei welcher die Abbruchbedingung erst am
		 * Ende geprüft wird.
		 * Bei der For- und While-Schleife wird dies vorab geprüft.
		 */
	}
}
