package GUI;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class HeaderPane {
	public static HBox makeHeader() {
		Text time = new Text();
		time.setText("Datum    Uhrzeit");
		Button mesg = new Button();
		mesg.setText("keine Nachrichten");
		HBox hRoot = new HBox();
		hRoot.setStyle("-fx-background-color: #336699;");

		hRoot.getChildren().addAll(mesg, time);
		return hRoot;
	}
}
