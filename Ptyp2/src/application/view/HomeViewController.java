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

	@FXML
	private Button mitarbeiterBearButton;
	@FXML
	private Button zeitenBearButton;
	@FXML
	private Button abrechnungButton;


	@SuppressWarnings("unused")
	public void timeInuputButtonClicked(ActionEvent ev) throws IOException {
		Parent tInView = FXMLLoader.load(getClass().getResource("TimeInputView.fxml"));
		MainViewController.redraw(tInView);
		/**
		 * TODO Verarbeitung der Eintraege
		 */
	}

	public void logoutButtonClicked(ActionEvent ev) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
		MainViewController.redraw(login);
		/**
		 * TODO Tatsaechlicher logout
		 */
	}

	public void eintraegeSehenButtonClicked(ActionEvent ev) throws IOException{
		Parent entries = FXMLLoader.load(getClass().getResource("ViewEntriesView.fxml"));
		MainViewController.redraw(entries);
		/**
		 * TODO Alles ausser fxml Verknuepfung
		 */
	}

	public void ProtokollButtonClicked(ActionEvent ev) throws IOException{

		/**
		 * TODO Alles ausser fxml Verknuepfung
		 */
	}

	public void mitarbeiterBearButtonClicked(ActionEvent ev) throws IOException {
		/**
		 * TODO Verarbeitung der Eintraege
		 */
	}

	public void zeitenBearButtonClicked(ActionEvent ev) throws IOException{
		// TODO
	}

	public void abrechnungErstellenButtonClicked(ActionEvent ev) throws IOException{
		//TODO
	}

}
