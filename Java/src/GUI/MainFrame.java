package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class MainFrame extends Application {
	Button login;

	@Override
	public void start(Stage primeStage) {
		try {
			primeStage.setTitle("TimeLapse");

			Scene myScene = LoginScene.makeLoginScene();


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
