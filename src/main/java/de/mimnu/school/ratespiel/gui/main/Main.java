package de.mimnu.school.ratespiel.gui.main;

import de.mimnu.school.ratespiel.gui.game.Database;
import de.mimnu.school.ratespiel.gui.screens.LoginScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Main instance;
	private Database database = new Database();

    public static void main(String args[]) {
		instance = new Main();
		
		getInstance().getDatabase().loadCache();
		
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Ratespiel");
		stage.setResizable(false);
		
		new LoginScreen().setScreen(stage);
	}

	public static Main getInstance() {
		return instance;
	}

	public Database getDatabase() {
		return database;
	}
}
