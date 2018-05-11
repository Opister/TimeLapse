package application.view;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import exceptions.BadTimeException;
import exceptions.TimeInvalidException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import protokoll.Protokoll;

/**
 * Controls time inputs
 *
 * @author himotaas
 *
 */
public class TimeInputController {

	private Protokoll protokoll;
	
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
		try {
			chosenDate = formatter.format(datePicker.getValue());

			if (chosenDate != null) {
				System.out.println(chosenDate);
			} else {
				throw new NullPointerException();
			}

			// Kommzeit

			if (isCorrectTimeInput()) {

				kommZeit = kommzeitHHTextField.getText().concat(":" + kommzeitMMTextField.getText());
				System.out.println(kommZeit);

			} else {
				throw new BadTimeException();
			}

			// Gehzeit
			if (isCorrectTimeInput() && gehzeitIstNachKommzeit()) {

				gehZeit = gehzeitHHTextField.getText().concat(":" + gehzeitMMTextField.getText());
				System.out.println(gehZeit);

			} else if (!gehzeitIstNachKommzeit()) {

				gehzeitHHTextField.clear();
				gehzeitMMTextField.clear();


				throw new TimeInvalidException();
			} else {

				throw new BadTimeException();

			}
			// write data

			if (protokoll.writeEntry(chosenDate, dtf.format(now), kommZeit, gehZeit, "Frank")) {

				errorDisplay.setText("Eintrag erfolgreich!");

			}

			// zurueck zu Home
			Parent home = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
			MainViewController.redraw(home);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erfolg!");
			alert.setHeaderText("Eintrag wurde erstellt.");
			alert.setContentText("waehlen sie 'Protokoll' um ihre Eintraege einzusehen");
			alert.showAndWait();


		} catch (BadTimeException ex) {
			errorDisplay.setText("Zeiteingabe ueberpruefen");

			// ex.printStackTrace();
		} catch (NullPointerException e) {
			errorDisplay.setText("Datum waehlen");
		} catch (NumberFormatException e) {
			errorDisplay.setText("Zeiteingabe ueberpruefen!");
		} catch (TimeInvalidException e) {
			errorDisplay.setText("Gehzeit muss nach Kommzeit liegen");
		}

	}

	public boolean isCorrectTimeInput() {
		if (Integer.parseInt(gehzeitMMTextField.getText()) < 60 && Integer.parseInt(gehzeitMMTextField.getText()) >= 0
				&& Integer.parseInt(gehzeitHHTextField.getText()) >= 0
				&& Integer.parseInt(gehzeitHHTextField.getText()) < 24)
			return true;
		else
			return false;

	}

	public boolean gehzeitIstNachKommzeit() {
		int gehMinutenInput = Integer.parseInt(gehzeitMMTextField.getText());
		int gehStundenInput = Integer.parseInt(gehzeitHHTextField.getText());

		int kommMinutenInput = Integer.parseInt(kommzeitMMTextField.getText());
		int kommStundenInput = Integer.parseInt(kommzeitHHTextField.getText());

		if ((gehStundenInput == kommStundenInput) && (gehMinutenInput < kommMinutenInput)) {
			return false;
		} else if (gehStundenInput < kommStundenInput) {
			return false;
		} else if ((gehStundenInput == kommStundenInput) && (gehMinutenInput == kommMinutenInput)) {
			return false;
		} else
			return true;

	}
}
