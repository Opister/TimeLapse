package application.view;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import exceptions.BadTimeException;
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
	private Label errorDisplay;

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

		String kommZeit;
		String chosenDate;
		String gehZeit;
		// eingetragenes Datum
		chosenDate = formatter.format(datePicker.getValue());
		System.out.println(chosenDate);
		try {
			// Kommzeit
			if (Integer.parseInt(kommzeitMMTextField.getText()) < 60
					&& Integer.parseInt(kommzeitMMTextField.getText()) >= 0
					&& Integer.parseInt(kommzeitHHTextField.getText()) >= 0
					&& Integer.parseInt(kommzeitHHTextField.getText()) < 24) {
				kommZeit = kommzeitHHTextField.getText().concat(":" + kommzeitMMTextField.getText());
				System.out.println(kommZeit);

			} else {
				throw new BadTimeException();
			}

			// Gehzeit
			if (Integer.parseInt(gehzeitMMTextField.getText()) < 60
					&& Integer.parseInt(gehzeitMMTextField.getText()) >= 0
					&& Integer.parseInt(gehzeitHHTextField.getText()) >= 0
					&& Integer.parseInt(gehzeitHHTextField.getText()) < 24) {
				gehZeit = gehzeitHHTextField.getText().concat(":" + gehzeitMMTextField.getText());
				System.out.println(gehZeit);
			} else {
				throw new BadTimeException();
			}
			// write data
			protokoll.writeEntry(chosenDate, dtf.format(now), kommZeit, gehZeit, "Frank");

			// zurueck zu Home
			Parent home = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
			MainViewController.redraw(home);
			/*
			 * TODO: eingegebene Daten auf falscheingaben ueberpruefen
			 */

		} catch (Exception ex) {
			if (ex instanceof BadTimeException || ex instanceof NumberFormatException) {
				errorDisplay.setText("Zeiteingabe ueberpruefen");
			}
			//ex.printStackTrace();
		}
	}

}
