package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class LoginPane {
	public static FlowPane makeLoginPane() {
		FlowPane root = new FlowPane();

		Button submit = new Button();
		submit.setText("Anmelden");

		TextField name = new TextField();
		TextField pw = new TextField();

		root.getChildren().addAll(name, submit, pw);
		return root;

	}
}
