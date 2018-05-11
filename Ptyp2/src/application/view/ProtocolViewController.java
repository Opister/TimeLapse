package application.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ProtocolViewController {
	@FXML
	public TextArea protocolTextArea;

	@FXML
	public Button backButton;

	public void backButtonClicked(ActionEvent ev) throws IOException {
		Parent homeView = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
		MainViewController.redraw(homeView);
	}
	public void updateTextArea(String text){
		protocolTextArea.setText(text);
	}


}
