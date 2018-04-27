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
	
	@FXML private BorderPane bPane;
	@FXML private AnchorPane aPane;
	@FXML private Label msg;
	@FXML private Label time;
	@FXML private Button login;
	@FXML private TextField uname;
	@FXML private TextField pw;
	@FXML private Label unamelabel;
	@FXML private Label pwlabel;
	@FXML private GridPane gPane;

	
	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("TimeLapse");
		Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		//Typsicherheit
		BorderPane mainPane = (BorderPane) root;
		mainPane.setCenter(FXMLLoader.load(getClass().getResource("HomeView.fxml")));
		
		Scene s = new Scene(root);
		
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void loginButtonClick(ActionEvent ev) {
		//Parent homeView = FXMLLoader.load();
	}
}
