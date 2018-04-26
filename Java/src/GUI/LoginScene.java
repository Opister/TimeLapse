package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class LoginScene {
	public static Scene makeLoginScene() {
		FlowPane root = new FlowPane();
		Scene erg = new Scene(root, 500, 500);

		Button submit = new Button();
		submit.setText("Anmelden");

		TextField name = new TextField();
		TextField pw = new TextField();

		root.getChildren().addAll(name, submit, pw);
		return erg;

	}
}
