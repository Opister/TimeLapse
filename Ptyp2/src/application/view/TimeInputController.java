package application.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import protokoll.Protokoll;

public class TimeInputController {

	private Protokoll protokoll;
	private String pickedDate;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private LocalDateTime now = LocalDateTime.now();

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

		protokoll = new Protokoll();

		// Format
		datePicker.setConverter(new StringConverter<LocalDate>() {

			@Override
			public LocalDate fromString(String arg0) {
				if (arg0 != null && !arg0.trim().isEmpty()) {
					return LocalDate.parse(arg0, formatter);
				}
				return null;
			}

			@Override
			public String toString(LocalDate date) {
				if (date != null) {

					return formatter.format(date);
				}
				return null;
			}

		});
		// eingetragenes Datum
		String chosenDate = formatter.format(datePicker.getValue());
		System.out.println(chosenDate);

		// Kommzeit
		String kommZeit = kommzeitHHTextField.getText().concat(":" + kommzeitMMTextField.getText());
		System.out.println(kommZeit);

		// Gehzeit
		String gehZeit = gehzeitHHTextField.getText().concat(":" + gehzeitMMTextField.getText());
		System.out.println(gehZeit);

		// write data
		protokoll.writeEntry(chosenDate, dtf.format(now), kommZeit, gehZeit, "Frank");

		// zurück zu Home
		Parent home = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
		MainViewController.redraw(home);
		/*
		 * TODO: eingegebene Daten auf falscheingaben überprüfen
		 */

	}

}
