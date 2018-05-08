package application.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class TimeInputController {

	@FXML
	private VBox rootBox;

	@FXML
	private DatePicker datePicker;

	@FXML
	private Label datumWaehlenLabel;
	@FXML
	private Label kommzeitLabel;
	@FXML
	private Label gehzeitLabel;
	@FXML
	private Label formatKommzeitLabel;
	@FXML
	private Label formatGehzeitLabel;

	@FXML
	private TextField kommzeitMMTextField;
	@FXML
	private TextField gehzeitMMTextField;
	@FXML
	private TextField kommzeitHHTextField;
	@FXML
	private TextField gehzeitHHTextField;

	@FXML
	private Button eintragenButton;
	@FXML
	private Button abbruchButton;

	public void abbrechenButtonClicked(ActionEvent ev) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
		MainViewController.redraw(home);
		/**
		 * TODO: ??
		 */
	}

	public void eintragenButtonClicked(ActionEvent ev) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
		MainViewController.redraw(home);
		/*
		 * TODO: eingegebene Daten weitergeben und verarbeiten
		 */
	}

}
