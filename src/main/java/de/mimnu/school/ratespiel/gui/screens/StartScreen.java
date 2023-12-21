package de.mimnu.school.ratespiel.gui.screens;

import de.mimnu.school.ratespiel.gui.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartScreen {
 
    private Scene scene;
	
	public void setScreen(Stage stage) {
		Label welcome = new Label("Herzlich Willkommen beim Ratespiel " + Main.getInstance().getUser().getActiveUsername() + ". :)");
		
		Button startButton = new Button("Start");
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new GameScreen().setScreen(stage);
			}
			
		});	
		
		Button highscoreButton = new Button("Highscore");
		highscoreButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new HighscoreScreen().setScreen(stage);
			}
		});
		
		Button exitButton = new Button("Beenden");
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});

		HBox buttons = new HBox(10);
		buttons.getChildren().addAll(startButton, highscoreButton, exitButton);
		buttons.setAlignment(Pos.CENTER);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(welcome, buttons);
		layout.setAlignment(Pos.CENTER);
		
		scene = new Scene(layout, 350, 250);
		
		stage.setScene(scene);
		stage.show();
	}
}
