package de.mimnu.school.ratespiel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ratespiel {
    
    public static void main(String args[]) {
		Random zufall = new Random();
		Scanner eingabe = new Scanner(System.in);
		
		HashMap<Integer, Integer> punktestand = new HashMap<>();
		HashMap<Integer, Long> rangliste = new HashMap<>();
		
		int zufallsZahl = zufall.nextInt(100) + 1;
		int gerateneZahl = 0;
		int durchlauf = 0;
		int spiel = 0;
		long rundenStart;
		boolean fehlerhafteEingabe = false;
		
		do {
			try {
				System.out.print("Herzlich Willkommen beim Ratespiel. :)\n"
						+ "Du musst eine Zahl zwischen 1 und 100 erraten.\n"
						+ "Errate die gesuchte Zahl: ");
				
				gerateneZahl = eingabe.nextInt();
				
				eingabe.nextLine();
				
				fehlerhafteEingabe = false;
			} catch(InputMismatchException e) {
				System.out.println("\nFehlerhafte Eingabe! Biite gebe eine Ganzzahl ein.\n");
				
				eingabe.next();
				
				fehlerhafteEingabe = true;
			}
		} while(fehlerhafteEingabe);
		
		rundenStart = System.currentTimeMillis();
		
		while(true) {
			durchlauf++;
			
			if(zufallsZahl == gerateneZahl) {
				spiel++;
				
				punktestand.put(spiel, durchlauf);
				rangliste.put(spiel, System.currentTimeMillis() - rundenStart);
				
				if(durchlauf <= 3) {
					System.out.println("\nGrandios! Du hast die Zahl sehr schnell erraten.");
				} else if(durchlauf <= 6) {
					System.out.println("\nHerzlichen Glückwunsch. Du hast die Zahl erfolgreich erraten.");
				} else {
					System.out.println("\nDu hast lange gebraucht um die Zahl zu erraten. Nächstes mal hast du vielleicht mehr Glück!");
				}
				
				durchlauf = 0;
				
				List<Map.Entry<Integer, Integer>> sortierterPunktestand = new ArrayList<>(punktestand.entrySet());
				List<Map.Entry<Integer, Long>> sortierteRangliste = new ArrayList<>(rangliste.entrySet());
				
				Collections.sort(sortierterPunktestand, Comparator.comparing(Map.Entry::getValue));
				Collections.sort(sortierteRangliste, Comparator.comparing(Map.Entry::getValue));
				
				System.out.println("\nDein Punktestand:");
				
				for(Map.Entry<Integer, Integer> punktestandAusgabe : sortierterPunktestand) {
					System.out.println("Spiel: " + punktestandAusgabe.getKey() + " Runden: " + punktestandAusgabe.getValue());
				}
				
				System.out.println("\nDeine Rangliste:");
				
				for(Map.Entry<Integer, Long> ranglisteAusgabe : sortierteRangliste) {
					System.out.println("Spiel: " + ranglisteAusgabe.getKey() + " Zeit: " + millisekundenZuZeit(ranglisteAusgabe.getValue()));
				}
				
				System.out.print("\nWenn du noch eine Runde spielen möchtest, dann tippe 'Neustart' ein: ");
				
				String neustart = eingabe.nextLine();
				
				if(!neustart.equalsIgnoreCase("Neustart")) {
					eingabe.close();
					
					System.out.print("\nVielen dank für das spielen des Ratespiels. :) ~ Made by Mimnu");
					
					break;
				}
				
				zufallsZahl = zufall.nextInt(100) + 1;
				
				do {
					try {
						System.out.print("\nHerzlich Willkommen zur nächsten Runde beim Ratespiel. :)\n"
								+ "Du musst eine Zahl zwischen 1 und 100 erraten.\n"
								+ "Errate die gesuchte Zahl: ");
						
						gerateneZahl = eingabe.nextInt();
						
						eingabe.nextLine();
						
						fehlerhafteEingabe = false;
					} catch(InputMismatchException e) {
						System.out.println("\nFehlerhafte Eingabe! Biite gebe eine Ganzzahl ein.");
						
						eingabe.next();
						
						fehlerhafteEingabe = true;
					}
				} while(fehlerhafteEingabe);
				
				rundenStart = System.currentTimeMillis();
				
				continue;
			} else {
				if(gerateneZahl > zufallsZahl) {
					System.out.println("\n" + gerateneZahl + " ist größer als meine Zahl.");
				} else {
					System.out.println("\n" + gerateneZahl + " ist kleiner als meine Zahl.");
				}
				
				if(gerateneZahl > zufallsZahl + 20) {
					System.out.print("\nUm 20 Punkte nach unten zu zählen, tippe 'Minus 20' ein.\n"
									+ "Möchtest du dies nicht tun, drücke Enter: ");
			
					String minusZwanzig = eingabe.nextLine();
					
					if(minusZwanzig.equalsIgnoreCase("Minus 20") || minusZwanzig.equalsIgnoreCase("Minus20") ||
							minusZwanzig.equalsIgnoreCase("Minus Zwanzig") || minusZwanzig.equalsIgnoreCase("MinusZwanzig")) {
						gerateneZahl -= 20;
						
						continue;
					}
				} else if(gerateneZahl < zufallsZahl - 20) {
					System.out.print("\nUm 20 Punkte nach oben zu zählen, tippe 'Plus 20' ein.\n"
									+ "Möchtest du dies nicht tun, drücke Enter: ");
					
					String plusZwanzig = eingabe.nextLine();
					
					if(plusZwanzig.equalsIgnoreCase("Plus 20") || plusZwanzig.equalsIgnoreCase("Plus20") ||
							plusZwanzig.equalsIgnoreCase("Plus Zwanzig") || plusZwanzig.equalsIgnoreCase("PlusZwanzig")) {
						gerateneZahl += 20;
						
						continue;
					}
				}
				
				do {
					try {
						System.out.print("\nErrate die gesuchte Zahl: ");
						
						gerateneZahl = eingabe.nextInt();
						
						eingabe.nextLine();
						
						fehlerhafteEingabe = false;
					} catch(InputMismatchException e) {
						System.out.println("\nFehlerhafte Eingabe! Biite gebe eine Ganzzahl ein.");
						
						eingabe.next();
						
						fehlerhafteEingabe = true;
					}
				} while(fehlerhafteEingabe);
			}
		}
	}
	
	private static String millisekundenZuZeit(long millisekunden) {
		long stunden = TimeUnit.MILLISECONDS.toHours(millisekunden),
			 minuten = TimeUnit.MILLISECONDS.toMinutes(millisekunden) % 60,
			 sekunden = TimeUnit.MILLISECONDS.toSeconds(millisekunden) % 60;
		
		return String.format("%02d:%02d:%02d", stunden, minuten, sekunden);
	}
}
