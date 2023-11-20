package com.example.chessgame.Pieces;

import com.example.chessgame.ChessBoard.ChessBoard;
import com.example.chessgame.Move.Location;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Pieces{

    // ---------------------- CONSRUCTOR -----------------------------
    public Queen(String color, ChessBoard chessboard){
        super("queen", color, chessboard);
        this.image = new Image("/" + color + "_" + this.type + ".png");
        this.imageView = new ImageView(image);
    }

    // ------------------------ METHODS ------------------------------
    @Override
    public boolean possibleMove(int x, int y){
        if(x < 0 || x > 7 || y < 0 || y > 7 ) return false;
        if(x == this.posX){
            return true;
        }
        if(y == this.posY){
            return true;
        }
        for (int i = 0; i < 8; i++) {
            if (x == this.posX + i && y == this.posY + i){
                return true;
            }
            if (x == this.posX + i && y == this.posY - i){
                return true;
            }
            if (x == this.posX - i && y == this.posY + i){
                return true;
            }
            if (x == this.posX - i && y == this.posY - i){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean obstacle(int x, int y,  int newX, int newY){
        return false;
    };
}
