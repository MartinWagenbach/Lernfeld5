package de.mimnu.school.ratespiel.gui.screens;

import de.mimnu.school.ratespiel.gui.database.User;
import de.mimnu.school.ratespiel.gui.main.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen {

    private User user = Main.getInstance().getUser();

    private Scene scene;
	
	public void setScreen(Stage stage) {
		Label hint = new Label("Wie möchtest du heißen?");

        TextField input = new TextField();
		input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(newValue.length() > 20) {
					input.setText(oldValue);
				}
			}
		});

        Button confirmButton = new Button("Bestätigen");
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String name = input.getText().trim().replaceAll(" ", "");

				if(!user.exists(name)) {
					user.add(name);
				}

				user.setActivePlayer(name);

                new StartScreen().setScreen(stage); 
			}
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(hint, input, confirmButton);
		layout.setAlignment(Pos.CENTER);
		layout.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				double wide = newValue.doubleValue();
				input.setMaxWidth(wide * 0.5);
			}
		});
		
		scene = new Scene(layout, 350, 250);
		
		stage.setScene(scene);
		stage.show();
	}
}
