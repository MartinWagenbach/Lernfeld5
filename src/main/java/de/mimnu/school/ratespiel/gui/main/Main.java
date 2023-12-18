package de.mimnu.school.ratespiel.gui.main;

import de.mimnu.school.ratespiel.gui.screens.StartScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String args[]) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Ratespiel");
		stage.setResizable(false);
		
		new StartScreen().setScreen(stage);
	}
}
