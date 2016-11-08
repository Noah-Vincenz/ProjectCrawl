package projectCrawl;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindow
{
	
	public MainWindow(Stage stage)
	{
		stage.setTitle("Oware Main Menu");

		Label owareLabel = new Label("Oware");
		owareLabel.setFont(Font.font("Calibri",FontWeight.BOLD,70));
		
		Button onePlayerButton = new Button("One Player Mode");
		Button twoPlayerButton = new Button("Two Player Mode");
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(owareLabel,onePlayerButton,twoPlayerButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout,600,450);
		stage.setScene(scene);
		stage.show();
		
		
		
	}
	
}
