package de.mimnu.school.ratespiel.gui.screens;

import de.mimnu.school.ratespiel.gui.game.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RestartScreen {
    
    private Scene scene;
	
	public void setScreen(Stage stage) {
		Game game = new Game();
		
		Label winnerMessage = new Label();
		winnerMessage.setTextFill(Color.DARKGREEN);
		
		game.setWinnerMessage(winnerMessage);
		
		Button restartButton = new Button("Neustart");
		restartButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new GameScreen().setScreen(stage);
			}
			
		});	
		
		Button menuButton = new Button("Menü");
		menuButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				new StartScreen().setScreen(stage);
			}
		});
		
		
		HBox buttons = new HBox(10);
		buttons.getChildren().addAll(restartButton, menuButton);
		buttons.setAlignment(Pos.CENTER);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(winnerMessage, buttons);
		layout.setAlignment(Pos.CENTER);
		
		scene = new Scene(layout, 350, 250);
		
		stage.setScene(scene);
		stage.show();
	}
}
