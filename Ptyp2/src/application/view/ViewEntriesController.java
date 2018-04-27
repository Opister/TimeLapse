package application.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class ViewEntriesController {

	@FXML
	private DatePicker anfangsDatumPicker;
	@FXML
	private DatePicker endeDatumPicker;
	@FXML
	private Label titelLabel;

	@FXML
	private Label vomLabel;
	@FXML
	private Label bisLabel;
	@FXML
	private TableView<String> eintragsTabelle;

	@FXML
	private Button zurueckButton;

	public void zurueckButtonClicked (ActionEvent ev) throws IOException{
		Parent home = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
		MainViewController.redraw(home);
	}
}
