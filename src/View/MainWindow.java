package View;

/**
 *
 * @author aking
 */
import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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

public class MainWindow {

    Button twoPlayerButton;

    public MainWindow(Stage stageMain) {

        Label owareLabel = new Label("Oware");
        owareLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 70));

        Button onePlayerButton = new Button("One Player Mode");
        Button twoPlayerButton = new Button("Two Player Mode");
        VBox layout = new VBox(10);
        layout.getChildren().addAll(owareLabel, onePlayerButton, twoPlayerButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 600, 450);
        stageMain.setScene(scene);
        stageMain.setTitle("Oware Main Menu");
//        MainWindow m  = this;
//        m.show();

        twoPlayerButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override

            public void handle(ActionEvent event) {
                Controller c = new Controller();
                View v = new View(c.getValues());
                v.setController(c);
                c.setView(v, c.getValues());
                v.show();
                c.setMainMenu(stageMain);
                stageMain.hide();

            }  
            
        });
        stageMain.show();
    

    }


}