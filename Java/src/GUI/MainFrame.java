package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class MainFrame extends Application {
	Button login;

	@Override
	public void start(Stage primeStage) {
		try {
			primeStage.setTitle("TimeLapse");
			BorderPane root = new BorderPane();

			root.setTop(HeaderPane.makeHeader());
			root.setCenter(LoginPane.makeLoginPane());

			Scene myScene = new Scene (root, 400, 400);

			primeStage.setScene(myScene);
			primeStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void poke(String[] a) {
		launch(a);
	}
}
