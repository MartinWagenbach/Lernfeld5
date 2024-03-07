package de.mimnu.school.struktogramme;

import java.util.Random;

public class KopfgesteuerteSchleife1 {

    public static void main(String args[]) {
        int a = 0, b = 0;
    
        while(a != 6) {
            b++;
            a = new Random().nextInt(6) + 1;
            if (a == 6) {
                System.out.println(b);
            }
        }
    }
}