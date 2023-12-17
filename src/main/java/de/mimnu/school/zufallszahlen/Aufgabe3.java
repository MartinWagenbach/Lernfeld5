package de.mimnu.school.zufallszahlen;

import java.util.Random;

public class Aufgabe3 {
    
    	public static void main(String args[]) {
		int min = 75, max = 500;
		int a = new Random().nextInt(min, max + 1);

		System.out.println(a);
	}
}
