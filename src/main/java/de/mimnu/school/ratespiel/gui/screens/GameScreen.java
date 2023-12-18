package de.mimnu.school.ratespiel.gui.screens;

import de.mimnu.school.ratespiel.gui.game.Game;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScreen {
    
    private Game game = new Game();
	private Scene scene;
	
	public void setScreen(Stage stage) {
		Label hint = new Label("Du musst eine Zahl zwischen 1 und 100 erraten.");
		
		Label output = new Label();
		output.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-padding: 5;");
		output.setAlignment(Pos.CENTER);
		
		TextField input = new TextField();
		input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(newValue.length() > 3) {
					input.setText(oldValue);
				}
			}
		});
		
		Button minusTwentyButton = new Button("- 20");
		minusTwentyButton.setDisable(true);
		minusTwentyButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				game.pressMinusTwentyButton(stage, input, output, minusTwentyButton, minusTwentyButton);
			}
		});
		
		Button plusTwentyButton = new Button("+ 20");
		plusTwentyButton.setDisable(true);
		plusTwentyButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				game.pressPlusTwentyButton(stage, input, output, plusTwentyButton, minusTwentyButton);
			}
		});
		
		Button confirmButton = new Button("Bestätigen");
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				game.pressConfirmButton(stage, input, output, plusTwentyButton, minusTwentyButton);
			}
		});
		
		HBox buttons = new HBox(10);
		buttons.getChildren().addAll(minusTwentyButton, confirmButton, plusTwentyButton);
		buttons.setAlignment(Pos.CENTER);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(hint, input, buttons, output);
		layout.setAlignment(Pos.CENTER);
		layout.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				double wide = newValue.doubleValue();
				input.setMaxWidth(wide * 0.1);
				output.setMaxWidth(wide * 0.5);
			}
		});
		
		scene = new Scene(layout, 350, 250);
		
		stage.setScene(scene);
		stage.show();
	}
}
