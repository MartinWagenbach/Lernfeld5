package de.mimnu.school.ratespiel.gui.main;

import de.mimnu.school.ratespiel.gui.database.User;
import de.mimnu.school.ratespiel.gui.screens.LoginScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Main instance;

	private User user = new User();

    public static void main(String args[]) {
		instance = new Main();

		getInstance().getUser().loadCache();
		
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

	public User getUser() {
		return user;
	}
}
