/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Board;
import Model.House;
import Model.Player;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author aking
 */
public final class View extends Stage {

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
    Label p2_Points_Top_Name;
    Label p1_Points_Top_Name;
    Label p2_Points_;
    Label p1_Points_;
    Button terminate, go_Back;
    Player p1;
    Player p2;
    public boolean isCpu = false;

    public void setCpu(boolean value) {
        isCpu = value;
    }

    public void changeP1(int point) {
        p1_Points_.setText("" + point);

    }

    public void changeP2(int point) {
        p2_Points_.setText("" + point);
    }
    int firstMove = 0;

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
            System.out.println(temp.getId());
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

        Random random = new Random();
        int randomNumber = random.nextInt(2);

        if (randomNumber == 0)//disable player 1 button
        {
            for (int buttonIndex = 0; buttonIndex < 6; ++buttonIndex) {
                listOfButtons.get(buttonIndex).setDisable(true);
            }

        } else {
            for (int buttonIndex = 6; buttonIndex < 12; ++buttonIndex) {
                listOfButtons.get(buttonIndex).setDisable(true);
            }
//           
        }
//        System.out.println(player1.size());
        int i = 0;
        for (Button x : listOfButtons) {
//            System.out.println(x.getId());
            x.getStyleClass().add("num-button");

            x.setId("" + i);

            x.setText("" + values.get(i));
            x.setOnAction(event -> {

                ArrayList<Integer> changes = c.handle(x);
                int j = 0;
                if (Integer.parseInt(x.getId()) >= 0 && Integer.parseInt(x.getId()) <= 5) {
                    //player 1
                    if (!x.getText().equals("0")) {
//                        this.changePlayerButtons(false, 2);
//                        this.changePlayerButtons(true, 1);
                        this.changeP1(c.player2);
                        this.changeP2(c.player1);

                    }
                } else {
                    // pp2 
                    if (!x.getText().equals("0")) {
//                        this.changePlayerButtons(false, 1);
//                        this.changePlayerButtons(true, 2);
                        this.changeP2(c.player1);
                        this.changeP1(c.player2);
                    }
                }
                for (Button b : listOfButtons) {
                    b.setText("" + changes.get(j));

                    j++;
                }
                if (Integer.parseInt(x.getId()) >= 0 && Integer.parseInt(x.getId()) <= 5) {
//                    player 1
                    if (!x.getText().equals("0")) {
//                        this.changePlayerButtons(false, 2);
//                        this.changePlayerButtons(true, 1);
                        this.changeP1(c.player2);
                        this.changeP2(c.player1);

                    }
                } else {
                    // pp2 
                    if (!x.getText().equals("0")) {
//                        this.changePlayerButtons(false, 1);
//                        this.changePlayerButtons(true, 2);
                        this.changeP2(c.player1);
                        this.changeP1(c.player2);
                    }
                }

            });

//  x.addEventFilter(MouseEvent.MOUSE_PRESSED,new Controller());
            i++;

        }
        if (randomNumber == 0) {
            firstMove = 1;

        }

        return grid;
    }

    public void setController(Controller contrl) {
        this.c = contrl;
    }

    public void changePlayerButtons(boolean setEnabled, int checkPlayer) {
        if (checkPlayer == 1) {
            for (int buttonIndex = 0; buttonIndex < 6; ++buttonIndex) {
                listOfButtons.get(buttonIndex).setDisable(setEnabled);
            }
        } else {
            for (int buttonIndex = 6; buttonIndex < 12; ++buttonIndex) {
                listOfButtons.get(buttonIndex).setDisable(setEnabled);
            }
        }
    }

    public View(Controller c1,boolean isWithCPU) {
        isCpu = isWithCPU;
        c = c1;
        listOfButtons = new ArrayList<>();
        player1 = new ArrayList<>();// Player 1 is AI 
        String css = this.getClass().getResource("/View/layoutstyle.css").toExternalForm();

        player2 = new ArrayList<>(); // Player 2 is User 

        BorderPane root = new BorderPane();

        //Setting the Bottom terminate and go back button // 
        terminate = new Button("TERMINATE");
        go_Back = new Button("Go Back");
        terminate.getStyleClass().add("buttonBottom");
        terminate.setOnAction(event -> {
        	 this.close();
        	 this.playAgain();
        });
        
        go_Back.getStyleClass().add("buttonBottom");
        go_Back.setOnAction(event -> {
        	this.close();
            c.getMainMenu().show();

        });

        HBox bottom_Buttons = new HBox();
        bottom_Buttons.setAlignment(Pos.CENTER);

        bottom_Buttons.getChildren().addAll(terminate, go_Back);
        bottom_Buttons.setPadding(new Insets(15, 12, 15, 12));
        bottom_Buttons.setSpacing(30);
        root.setBottom(bottom_Buttons);

        // End bottom 
        Scene scene = new Scene(root, 1000, 500);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(css);
        Button button1 = new Button("Hello");
        grid = allButtons(c1.getValues());
        if (firstMove == 1 && isCpu == true) {

            c.doFirstMoveCPU();
            this.changePlayerButtons(false, 1);
            this.changePlayerButtons(true, 2);
        }

        grid.setHgap(6);
        grid.setVgap(6);

        root.setCenter(grid);
        root.getStyleClass().add("mainBackGround");

        // Player 1 Left hand side  
        /*
        Try CSS ??? To Layout style 
         */
        BorderPane leftHandGrid = new BorderPane();
        leftHandGrid.setPadding(new Insets(10, 20, 10, 40));

        p1_Points_Top_Name = new Label("Player1");
        leftHandGrid.setTop(p1_Points_Top_Name);

        p1_Points_ = new Label("0");
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

        p2_Points_Top_Name = new Label("Player2");
        rightHandGrid.setTop(p2_Points_Top_Name);

        p2_Points_ = new Label("0");

        settingLabelFX(p2_Points_);// Setting fx for pl2 points and top label
        settingLabelFX(p2_Points_Top_Name);// Setting fx for pl2 points and top label
        rightHandGrid.setCenter(p2_Points_);
        root.setRight(rightHandGrid);

        // End of player 2 right hand side 
        this.setTitle("Oware");
        this.setScene(scene);

    }
    
    public void playAgain(){

   	 Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("CONGRATULATIONS!");
        
        alert.setHeaderText("Player 1's Score: " + c.getManual_Player2().getScore()  + '\n' + "Player 2's Score: " + c.getCpu_Player1().getScore());
       
        if(c.getManual_Player2().getScore()  > c.getCpu_Player1().getScore()){
       	 alert.setContentText("Player 1 is the winner");
        }
        else if(c.getManual_Player2().getScore() < c.getCpu_Player1().getScore()){
       	 alert.setContentText("Player 2 is the winner");
        }
        else{
       	 alert.setContentText("Draw!");
        }
        
        ButtonType playAgain = new ButtonType("Play Again");
        ButtonType exitGame = new ButtonType("Exit Game");

        alert.getButtonTypes().setAll(playAgain, exitGame);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == playAgain) {
       	 
       	 c.getMainMenu().show();
       	 
        } 
        
        else if (result.get() == exitGame) {
            this.close();
        }
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
        l.getStyleClass().add("scoreColor");
    }

    private void seettingButtonFX(Button b) {
        b.setStyle("-fx-font: 20 arial; -fx-base: #EE2211;");
    }

}
