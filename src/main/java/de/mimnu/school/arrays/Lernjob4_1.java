package de.mimnu.school.arrays;

public class Lernjob4_1 {
    public static void main(String args[]) {
        //Aufgabe 1
        int[] array = new int[3];

        array[0] = 61;
        array[1] = 60;
        array[2] = 64;

        System.out.println("Platz 0: " + array[0]);
        System.out.println("Platz 1: " + array[1]);
        System.out.println("Platz 2: " + array[2] + "\n");

        //Aufgabe 2
        int[] array2 = new int[10];

        for(int i = 0; i < array2.length; i++) {
            array2[i] = (i + 1) * 10;
            System.out.println("Platz " + i + ": " + array2[i]);
        }

        System.out.println("\n");

        //Aufgabe 3
        float[] array3 = new float[100];

        for(int i = 0; i < array3.length; i++) {
            array3[i] = (i + 1);
            System.out.println("Platz " + i + ": " + array3[i]);
        }
    }
}
