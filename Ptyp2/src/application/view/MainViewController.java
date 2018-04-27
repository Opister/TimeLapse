package application.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainViewController extends Application {

	static Stage mainStage;
	static Parent root;

	static Parent home;

	@FXML
	private BorderPane bPane;
	@FXML
	private AnchorPane aPane;
	@FXML
	private Label msg;
	@FXML
	private Label time;

	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("TimeLapse");
		mainStage = primaryStage;
		home = FXMLLoader.load(getClass().getResource("HomeView.fxml"));

		root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		// Typsicherheit
		BorderPane mainPane = (BorderPane) root;
		mainPane.setCenter(FXMLLoader.load(getClass().getResource("LoginView.fxml")));

		Scene s = new Scene(root);

		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void redraw(Parent view) throws IOException {

		// Typsicherheit
		BorderPane mainPane = (BorderPane) root;
		mainPane.setCenter(view);

		// Scene s = new Scene(root);

		// mainStage.setScene(s);

		// mainStage.hide();
		mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
