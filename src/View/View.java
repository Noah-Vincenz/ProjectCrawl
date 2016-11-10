/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Board;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author aking
 */
public class View extends Stage {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    ArrayList<Button> listOfButtons;
    GridPane grid;
    ArrayList<Button> player1;// Player 1 is AI 
    ArrayList<Button> player2; // Player 2 is User 
    Board board;
    Controller c;

    private GridPane allButtons(ArrayList<Integer> values) {
        /* 
        Setting grid set Alignment to the center so the grid will stay in the center 
        Otherwise it will go the the left. Like the flow layout. 
         */
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        for (int i = 0; i < 12; ++i) {  //Buttons till 6  
            Button temp = new Button("AC");
            temp.setId("" + i);// Giving buttons a text 
            //temp.setId("" + i); // Setting Id So we Can regonise (MAYBE NOT NEEDED IN THE LONG RUN)

//            listOfButtons.add(temp); // Adding all made buttons to the list 
            if (i < 6) {
                // Buttons For Player1 
                /* 
                Adding buttons to list DS for player 2  (data structure)
                For Check etc. 
                 */
                player1.add(temp);

                // Setting Id So we Can regonise (MAYBE NOT NEEDED IN THE LONG RUN)
                grid.add(temp, i, 1); // row 1 and column i  

            } else {
                // Buttons For player2 
                int newColm = i % 6;
                /* 
                Adding buttons to list DS for player 2  (data structure)
                For Check etc. 
                 */

                player2.add(temp);
                grid.add(temp, newColm, 2); // Row 2 and column "New Column" (start again from index 0 so its aligment to player 2)
            }
        }
        for (int j = (player2.size() - 1); j >= 0; --j) {
            listOfButtons.add(player2.get(j));
        }
        for (int i = 0; i < 6; ++i) {

            listOfButtons.add(player1.get(i));

        }

//        System.out.println(player1.size());
        int i = 0;
        for (Button x : listOfButtons) {
//            System.out.println(x.getId());
            seettingButtonFX(x);
            x.setId("" + i);

            x.setText("" +values.get(i));
            x.setOnAction(event -> {
                ArrayList<Integer> changes = c.handle(x);
                int j = 0;
                for (Button b : listOfButtons) {
                    b.setText("" + changes.get(j));

                    j++;
                }

            });

//  x.addEventFilter(MouseEvent.MOUSE_PRESSED,new Controller());
            i++;

        }

        return grid;
    }

    public void setController(Controller contrl) {
        this.c = contrl;
    }

    public View(ArrayList<Integer> values) {
        listOfButtons = new ArrayList<>();
        player1 = new ArrayList<>();// Player 1 is AI 
        player2 = new ArrayList<>(); // Player 2 is User 

        BorderPane root = new BorderPane();
        Button button1 = new Button("Hello");
        GridPane grid = allButtons(values);
        grid.setHgap(6);
        grid.setVgap(6);

        root.setCenter(grid);

        // Player 1 Left hand side  
        /*
        Try CSS ??? To Layout style 
         */
        BorderPane leftHandGrid = new BorderPane();
        leftHandGrid.setPadding(new Insets(10, 20, 10, 40));

        Label p1_Points_Top_Name = new Label("Player1");
        leftHandGrid.setTop(p1_Points_Top_Name);

        Label p1_Points_ = new Label("0");
        leftHandGrid.setCenter(p1_Points_);
        settingLabelFX(p1_Points_Top_Name);// Setting fx for pl2 points and top label
        settingLabelFX(p1_Points_);// Setting fx for pl2 points and top label
        root.setLeft(leftHandGrid);

        // End of player 1 RIGHT hand side 
        //  Space // 
        //  Space // 
        //  Space // 
        // Player2 
        /*
        Try CSS ??? To Layout style 
         */
        BorderPane rightHandGrid = new BorderPane();
        rightHandGrid.setPadding(new Insets(10, 20, 10, 40));

        Label p2_Points_Top_Name = new Label("Player2");
        rightHandGrid.setTop(p2_Points_Top_Name);

        Label p2_Points_ = new Label("0");

        settingLabelFX(p2_Points_);// Setting fx for pl2 points and top label
        settingLabelFX(p2_Points_Top_Name);// Setting fx for pl2 points and top label
        rightHandGrid.setCenter(p2_Points_);
        root.setRight(rightHandGrid);

        // End of player 2 right hand side 
        this.setTitle("Try");
        this.setScene(new Scene(root, 600, 500));

    }

    public ArrayList<Button> getAllButtons() {
        return listOfButtons;
    }

    public void updateGrid(ArrayList<Integer> values) {
        int i = 0;
        for (int val : values) {
            listOfButtons.get(i).setText("" + val);

            i++;
        }

    }

    private void settingLabelFX(Label l) {
        l.setStyle(""// "-fx-background-color: slateblue;" // Setting backround to state blue 
                // + " -fx-text-fill: white;" // Setting text colour to white 
                + "-fx-stroke-width: 1;"
                + " -fx-font:35px Tahoma;");
    }

    private void seettingButtonFX(Button b) {
        b.getStyleClass().add("button.css");
    }

}