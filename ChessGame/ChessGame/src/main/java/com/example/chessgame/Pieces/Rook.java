package com.example.chessgame.Pieces;

import com.example.chessgame.ChessBoard.ChessBoard;
import com.example.chessgame.Move.Location;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Pieces{

    // ---------------------- CONSRUCTOR -----------------------------
    public Rook(String color, ChessBoard chessboard){
        super("rook", color, chessboard);
        this.image = new Image("/" + color + "_" + this.type + ".png");
        this.imageView = new ImageView(image);
        this.firstmove = true;
    }

    // ------------------------ METHODS ------------------------------
    @Override
    public boolean possibleMove(int x, int y){
        if (x < 0 || x > 7 || y < 0 || y > 7) return false;
        if (x == this.posX){
            return true;
        }
        if (y == this.posY){
            return true;
        }
        return false;
    }
    @Override
    public boolean obstacle(int x, int y){
        if (x < 0 || x > 7 || y < 0 || y > 7) return false;
        if (x != this.posX && y == this.posY){
            if (x > this.posX){ //---------------------------- check up to bottom OK
                System.out.println("to bottom");
                for (int i = this.posX + 1; i < x; i++) {
                    if (!this.chessboard.getSquare(i, y).isFreeCase()) return false;
                }
            }
            if(x < this.posX){ // ---------------------------- check bottom to up
                System.out.println("to up");
                for (int i = x + 1 ; i < this.posX; i++) {
                    if (!this.chessboard.getSquare(i, y).isFreeCase()) return false;
                }
            }
            return true;
        }
        if(x == this.posX && y != this.posY){
            if (y > this.posY){ // ---------------------------check left to right OK
                System.out.println("to right");
                for (int i = this.posY + 1; i < y ; i++) {
                    if (!this.chessboard.getSquare(x, i).isFreeCase()) return false;
                }
            }
            if (y < this.posY){ // --------------------------- check right to left
                System.out.println("to left");
                for (int i = y + 1; i < this.posY - 1; i++) {
                    if (!this.chessboard.getSquare(x, i).isFreeCase()) return false;
                }
            }
            return true;
        }
        return false;
    };
}
