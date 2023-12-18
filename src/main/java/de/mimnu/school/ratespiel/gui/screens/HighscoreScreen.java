package de.mimnu.school.ratespiel.gui.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HighscoreScreen {
    
    private Scene scene;
	
	public void setScreen(Stage stage) {
		Label heading = new Label("Highscore");
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(heading);
		layout.setAlignment(Pos.CENTER);
		
		scene = new Scene(layout, 350, 250);
		
		stage.setScene(scene);
		stage.show();
	}
}
