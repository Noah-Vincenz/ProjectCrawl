

import View.MainWindow;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author aking
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindow m = new MainWindow(primaryStage);
    
        
              
    }
}