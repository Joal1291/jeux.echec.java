package com.example.chessgame.Pieces;

import com.example.chessgame.ChessBoard.ChessBoard;
import com.example.chessgame.Move.Location;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Pieces{

    // ---------------------- CONSRUCTOR -----------------------------
    public Knight(String color, ChessBoard chessboard){
        super("knight", color, chessboard);
        this.image = new Image("/" + color + "_" + this.type + ".png");
        this.imageView = new ImageView(image);
    }

    // ------------------------ METHODS ------------------------------
    @Override
    public boolean possibleMove(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) return true;
        if (x == this.posX + 2 && y == this.posY - 1) {
            return true;
        }
        if (x == this.posX + 2 && y == this.posY + 1) {
            return true;
        }
        if (x == this.posX - 2 && y == this.posY - 1) {
            return true;
        }
        if (x == this.posX - 2 && y == this.posY + 1) {
            return true;
        }
        if (x == this.posX + 1 && y == this.posY - 2) {
            return true;
        }
        if (x == this.posX + 1 && y == this.posY + 2) {
            return true;
        }
        if (x == this.posX - 1 && y == this.posY + 2) {
            return true;
        }
        if (x == this.posX - 1 && y == this.posY - 2) {
            return true;
        }
        return false;
    }
    @Override
    public boolean obstacle(int x, int y){
        return true;
    };
}
