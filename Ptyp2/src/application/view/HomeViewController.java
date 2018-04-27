package application.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeViewController {
	@FXML
	private Button zeitEintragenButton;
	@FXML
	private Button fehlzeitButton;
	@FXML
	private Button eintaegeSehenButton;
	@FXML
	Button logoutButton;
	@FXML
	Button protokollButton;

	@FXML
	private Label offeneTageLabel;
	@FXML
	private Label offeneFehlLabel;

	@SuppressWarnings("unused")
	public void timeInuputButtonClicked(ActionEvent ev) throws IOException {
		Parent tInView = FXMLLoader.load(getClass().getResource("TimeInputView.fxml"));
		MainViewController.redraw(tInView);
	}

	public void logoutButtonClicked(ActionEvent ev) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
		MainViewController.redraw(login);
		/**
		 * TODO Tatsaechlicher logout
		 */
	}

	public void ProtokollButtonClicked(ActionEvent ev) throws IOException{

		/**
		 * TODO Alles ausser fxml Verknuepfung
		 */
	}
}
