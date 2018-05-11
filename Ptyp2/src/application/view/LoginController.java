package application.view;

import java.io.IOException;

import data.sql.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginController {
	@FXML
	private Button login;
	@FXML
	private TextField uname;
	@FXML
	private TextField pw;
	@FXML
	private Label unamelabel;
	@FXML
	private Label pwlabel;
	@FXML
	private GridPane gPane;

	public void loginButtonClick(ActionEvent ev) throws IOException {
		String name = uname.getCharacters().toString();
		String password = pw.getCharacters().toString();

		if (Login.checkID(name)) {
			if (Login.userLogin(name, password) != null) {
				String currentUser = name;
				Parent homeView = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
				MainViewController.redraw(homeView);
			}

		} else{
			System.out.println("Invalid ID!");
			}
	}
}
