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
import java.util.Optional;
import java.util.Random;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author aking
 */
public class Controller {

    Board board;

    boolean withCpu = false;
    Player cpu_Player1;
    Player manual_Player2;
    View view;
    ArrayList<Integer> values;
    public int player1;
    public int player2;

    Stage mainMenu;

    public void setMainMenu(Stage parent) {
        mainMenu = parent;
    }

    public Stage getMainMenu() {
        return mainMenu;
    }

    public Controller() {

        // 
        board = new Board();
        cpu_Player1 = board.getPlayer1();
        manual_Player2 = board.getPlayer2();
        //manual_Player2.setInitialScore(24);

//        int j = 0;
//        for (House i : board.getHouses()) {
//            if (j >= 0 && j <= 5) {
//                i.clearHouse();
//            }
//            j++;
//        }
        values = new ArrayList<>();
        board.getHouses().forEach((i) -> {
            values.add(i.getSeeds());
        });

    }

    public void setView(View v, ArrayList<Integer> values) {
        view = v;
        v.updateGrid(values);
    }

    public void updateBoard() {
        view.updateGrid(values);
    }

    public void doFirstMoveCPU() {
        Random random = new Random();
        int randomNumber = 6;
        while (true) {
            randomNumber = random.nextInt(6) + 6;
            if (board.getHouses().get(randomNumber).getSeeds() != 0) {
                System.out.println("Index value is --> " + randomNumber + " <===> Value of the seed is ==> " + board.getHouses().get(randomNumber).getSeeds());
                break;
            }
        }

        cpu_Player1.sowAndCapture(randomNumber);
        player1 = cpu_Player1.getScore();
        player2 = manual_Player2.getScore();

        values.clear();
        values = new ArrayList<>();
        for (House i : board.getHouses()) {
            values.add(i.getSeeds());
        }

        //  view.updateGrid(values);
    }

    public ArrayList<Integer> handle(Button b) {

        Button btnPressed = b;
//         Player depends
        int indexForButton = Integer.parseInt(btnPressed.getId());

        if (withCpu) {
            if (indexForButton >= 0 && indexForButton <= 5) {
                // player is CPU ==> player1 
                manual_Player2.sowAndCapture(indexForButton);
                player2 = manual_Player2.getScore();
                player1 = cpu_Player1.getScore();

                Random random = new Random();
                int randomNumber = 6;
                while (true) {
                    randomNumber = random.nextInt(6) + 6;
                    if (board.getHouses().get(randomNumber).getSeeds() != 0) {
                        System.out.println("Index value is --> " + randomNumber + " <===> Value of the seed is ==> " + board.getHouses().get(randomNumber).getSeeds());
                        break;
                    }
                }

                cpu_Player1.sowAndCapture(randomNumber);
                player1 = cpu_Player1.getScore();
                player2 = manual_Player2.getScore();
                view.changePlayerButtons(true, 2);
                view.changePlayerButtons(false, 1);

            }
        } else {

            if (indexForButton >= 0 && indexForButton <= 5) {
                // player is CPU ==> player1 
                manual_Player2.sowAndCapture(indexForButton);
                if (!manual_Player2.isEmpty()) {

//            view.changePlayerButtons(false, 2);
                    player2 = manual_Player2.getScore();
                    player1 = cpu_Player1.getScore();
                    view.changePlayerButtons(true, 1);
                    view.changePlayerButtons(false, 2);
                } else {
//                System.out.println("Come here p1 ");
//                view.changePlayerButtons(false, 1);
//                view.changePlayerButtons(true, 2);
//
//                values.clear();
//                values = new ArrayList<>();
//                for (House i : board.getHouses()) {
//                    values.add(i.getSeeds());
//                }
//                return values;
                }

                //  view.changeP1(manual_Player2.getScore());
//            view.changePlayerButtons(true, 1);
            } else if (withCpu == true) {

                Random random = new Random();
                int randomNumber = random.nextInt(6);

                cpu_Player1.sowAndCapture(randomNumber);
                player1 = cpu_Player1.getScore();
                player2 = manual_Player2.getScore();

                //int winning = board.checkWin();
            } else {

                cpu_Player1.sowAndCapture(indexForButton);
                player1 = cpu_Player1.getScore();
                player2 = manual_Player2.getScore();
                //  view.changeP2(cpu_Player1.getScore());
                view.changePlayerButtons(false, 1);
                view.changePlayerButtons(true, 2);
            }
        }

        values.clear();
        values = new ArrayList<>();
        for (House i : board.getHouses()) {
            values.add(i.getSeeds());
        }

        int winning = board.checkWin();

        if (winning == 1) {
            refreshGame(winning);
        } else if (winning == 2) {
            refreshGame(winning);
        } else if (winning == 3) {
            refreshGame(winning);

        }

        // refreshGame(winning);
//        
//        view.changeP2(cpu_Player1.getScore());
//        view.changeP1(manual_Player2.getScore());
        return values;

    }

    public void refreshGame(int winner) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("CONGRATULATIONS!");
        if (winner == 1) {
            alert.setHeaderText("And the winner is Player 2!");
        } else if (winner == 2) {
            alert.setHeaderText("And the winner is Player 1!");
        } else {
            alert.setHeaderText("It's a draw!");
        }

        ButtonType playAgain = new ButtonType("Play Again");
        ButtonType exitGame = new ButtonType("Exit Game");

        alert.getButtonTypes().setAll(playAgain, exitGame);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == playAgain) {
            view.close();
            getMainMenu().show();

        } else if (result.get() == exitGame) {
            view.close();
        }
    }

    public void setCPU(boolean Ai) {
        withCpu = Ai;
    }

    public Player getManual_Player2() {
        return manual_Player2;
    }

    public Player getCpu_Player1() {
        return cpu_Player1;
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

}
