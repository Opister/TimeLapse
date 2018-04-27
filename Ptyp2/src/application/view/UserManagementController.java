package application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserManagementController {
	@FXML
	private Label suchenLabel;
	@FXML
	private TextField suchenTextField;
	@FXML
	private TableView<String> mitarbeiterTabelle;

	@FXML
	private Button zurueckButton;
	@FXML
	private Button detailsButton;
	@FXML
	private Button bearbeitenButton;
}
