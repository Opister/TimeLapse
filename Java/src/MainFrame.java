import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainFrame extends Application {
	Button login;

	@Override
	public void start(Stage primeStage) {
		try {
			primeStage.setTitle("TimeLapse");

			StackPane root = new StackPane();
			Scene myScene = new Scene(root, 400, 400);

			login = new Button();
			login.setText("Anmelden");

			root.getChildren().add(login);

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
