package com.example.chessgame;

import com.example.chessgame.ChessBoard.Square;
import com.example.chessgame.ChessBoard.ChessBoard;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessGame extends Application {
//    private int x;
//    private int y;
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Chess Game"); // set title to the game

        ChessBoard chessBoard = new ChessBoard(); // gridPane create to display the chessboard

        StackPane stackPane= new StackPane();

        stackPane.getChildren().add(chessBoard);
        chessBoard.setAlignment(javafx.geometry.Pos.CENTER);
        primaryStage.show(); // display the window

        Scene scene = new Scene(stackPane, 900, 900);

        primaryStage.setScene(scene);

    }

    public void displayPos(int x, int y, String valueOfCase){
        System.out.println("value of case: " + valueOfCase);
    }
    public static void main(String[] args) {
        launch();
    }
}
// --- VARIABLES ---
// --- CONSTRUCTOR ---
// --- GETTER, SETTER ---
// --- METHODS ---