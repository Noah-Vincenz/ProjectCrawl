/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
    	//primaryStage.setResizable(false);
        MainWindow m = new MainWindow(primaryStage);
           
    }
}
