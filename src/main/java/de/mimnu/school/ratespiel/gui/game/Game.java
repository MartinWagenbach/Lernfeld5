package de.mimnu.school.ratespiel.gui.game;

import java.util.Random;

import de.mimnu.school.ratespiel.gui.database.User;
import de.mimnu.school.ratespiel.gui.main.Main;
import de.mimnu.school.ratespiel.gui.screens.RestartScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Game {
    
	private User user = Main.getInstance().getUser();

    private Random random = new Random();
	
	private int randomNumber;
	private int guessedNumber;
	private int round = 0;
	private long roundStart;
	
	public Game() {
		randomNumber = random.nextInt(100) + 1;
		roundStart = System.currentTimeMillis();
	}
	
	public void pressConfirmButton(Stage stage, TextField input, Label output, Button plusTwentyButton, Button minusTwentyButton) {
		guessedNumber = getIntFromText(input);
		
		checkGuessedNumber(stage, input, output, plusTwentyButton, minusTwentyButton);
	}
	
	public void pressPlusTwentyButton(Stage stage, TextField input, Label output, Button plusTwentyButton, Button minusTwentyButton) {
		guessedNumber += 20;
		
		checkGuessedNumber(stage, input, output, plusTwentyButton, minusTwentyButton);
	}
	
	public void pressMinusTwentyButton(Stage stage, TextField input, Label output, Button plusTwentyButton, Button minusTwentyButton) {
		guessedNumber -= 20;
		
		checkGuessedNumber(stage, input, output, plusTwentyButton, minusTwentyButton);
	}
	
	public void setWinnerMessage(Label winnerMessage) {
		if(round <= 3) {
			winnerMessage.setText("Grandios! Du hast die Zahl sehr schnell erraten.");
		} else if(round <= 6) {
			winnerMessage.setText("Herzlichen Glückwunsch. Du hast die Zahl erfolgreich erraten.");
		} else {
			winnerMessage.setText("Du hast lange gebraucht um die Zahl zu erraten. \n    Nächstes mal hast du vielleicht mehr Glück!");
		}
		
		round = 0;
	}
	
	private void checkGuessedNumber(Stage stage, TextField input, Label output, Button plusTwentyButton, Button minusTwentyButton) {
		String name = user.getActiveUsername();

		round++;
		
		input.setText("");
		
		if(guessedNumber != -1) {
			if(guessedNumber == randomNumber) {
				if(user.getBestRound(name) == 0) {
					user.setBestRound(name, round);
				} else if(user.getBestRound(name) > round) {
					user.setBestRound(name, round);
				}

				if(user.getBestRoundTime(name) == 0) {
					user.setBestRoundTime(name, System.currentTimeMillis() - roundStart);
				} else if(user.getBestRoundTime(name) > System.currentTimeMillis() - roundStart) {
					user.setBestRoundTime(name, System.currentTimeMillis() - roundStart);
				}
				
				new RestartScreen().setScreen(stage);
			} else if(guessedNumber < randomNumber) {
				output.setText(guessedNumber + " ist kleiner als meine Zahl.");
				output.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-padding: 5;");
				
				if(guessedNumber < randomNumber - 20) {
					plusTwentyButton.setDisable(false);
					minusTwentyButton.setDisable(true);
				} else {
					plusTwentyButton.setDisable(true);
				}
			} else {
				output.setText(guessedNumber + " ist größer als meine Zahl.");
				output.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-padding: 5;");
				
				if(guessedNumber > randomNumber + 20) {
					minusTwentyButton.setDisable(false);
					plusTwentyButton.setDisable(true);
				} else {
					minusTwentyButton.setDisable(true);
				}
			}
		} else {
			output.setText("Bitte gebe eine Zahl ein!");
			output.setStyle("-fx-border-color: darkred; -fx-border-radius: 10; -fx-padding: 5;");
		}
	}
	
	private int getIntFromText(TextField input) {
		String text = input.getText().trim();
		
		if(text.isEmpty()) {
			return -1;
		}
		
		try {
			return Integer.parseInt(text);
		} catch(NumberFormatException e) {
			return -1;
		}
	}
}
