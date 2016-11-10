/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Board;
import Model.House;
import Model.Player;
import View.View;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author aking
 */
public class Controller {

    Board board;
    Player cpu_Player1;
    Player manual_Player2;
    View view;
    ArrayList<Integer> values;

    public Controller() {

        
        board = new Board();
        cpu_Player1 = board.getPlayer1();
        manual_Player2 = board.getPlayer2();
        values = new ArrayList<>();
        for (House i : board.getHouses()) {
            values.add(i.getSeeds());
        }

    }

    public void setView(View v, ArrayList<Integer> values) {
        view = v;
        v.updateGrid(values);

    }

    public void updateBoard() {
        view.updateGrid(values);
    }

    public ArrayList<Integer> handle(Button b) {

        Button btnPressed = b;
//         Player depends
        int indexForButton = Integer.parseInt(btnPressed.getId());
        if (indexForButton >= 0 && indexForButton <= 5) {
            // player is CPU ==> player1 
            cpu_Player1.sowAndCapture(indexForButton);

            //manual_Player2.sowAndCapture(indexForButton);

        } else {

            //cpu_Player1.sowAndCapture(indexForButton);
            manual_Player2.sowAndCapture(indexForButton);

        }
        for (House h : board.getHouses()) {
            System.out.println("Values are " + h.getSeeds());
        }
        values.clear();
        values = new ArrayList<>();
        for (House i : board.getHouses()) {
            values.add(i.getSeeds());
        }
        return values;

    }

}