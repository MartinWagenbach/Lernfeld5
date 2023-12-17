package de.mimnu.school.bedingungen;

public class Aufgabe2 {
    
    public static void main(String args[]) {
		int a = 17, b = 57, c = 61;
		
		if(a == b) {
			System.out.println("Die Variable a hat die gleiche Größe wie b.");
		} else {
			System.out.println("Die Variable a hat nicht die gleiche Größe wie b.");
			
			if(a == c) {
				System.out.println("Die Variable a hat die gleiche Größe wie c.");
			} else {
				System.out.println("Die Variable a hat nicht die gleiche Größe wie c.");
			}
		}
	}
}
