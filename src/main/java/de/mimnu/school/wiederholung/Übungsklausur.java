package de.mimnu.school.wiederholung;

import java.util.Random;

public class Übungsklausur {
    
    	public static void main(String args[]) {
		//Aufgabe 1a
		int whole = 0, 
			whole2 = 0, 
			wholeSum = 0;
		
		//Aufgabe 1b
		float coma = 0, 
			  coma2 = 0, 
			  comaSum = 0;
		
		//Aufgabe 1c
		boolean truth = false, 
				truth2 = false;
		
		//Aufgabe 2a
		whole = 523; whole2 = 114;
		wholeSum = whole + whole2;
		
		//Aufgabe 2b
		coma = 2.75f; coma2 = 7.2f;
		comaSum = coma + coma2;
		
		//Aufgabe 3a
		wholeSum = 0;
		
		for(int i = 1; i <= 100; i++) {
			wholeSum += i;
		}
		
		//Aufgabe 3b
		wholeSum = 0;
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				wholeSum += i;
			}
		}
		
		//Aufgabe 4a
		int ranNumber = new Random().nextInt(101);
		
		if(ranNumber == 42) {
			truth = true;
		} else {
			truth = false;
		}
		
		//Aufgabe 4b
		wholeSum = 0;
		
		for(int i = 1; i <= 100; i++) {
			wholeSum += new Random().nextInt(51);
		}
		
		if(wholeSum > 2000) {
			truth2 = true;
		} else {
			truth2 = false;
		}
	}
}
