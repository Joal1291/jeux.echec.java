package com.example.chessgame.Pieces;

import com.example.chessgame.ChessBoard.ChessBoard;
import com.example.chessgame.Move.Location;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Pieces{
    // ----------------------- CONSTRUCTOR -------------------------------
    public King(String color, ChessBoard chessboard){
        super("king", color, chessboard);
        System.out.println("/" + color + "_king.png");
        this.image = new Image("/" + color + "_king.png");
        this.imageView = new ImageView(image);
        this.firstmove = true;
    }

    // ------------------------ METHODS ------------------------------
    @Override
    public boolean possibleMove(int x, int y){
        if(x < 0 || x > 7 || y < 0 || y > 7) return false;
        if(x == this.posX + 1 && y == this.posY){
            return true;
        }
        if(x == this.posX - 1 && y == this.posY){
            return true;
        }
        if(x == this.posX && y == this.posY + 1){
            return true;
        }
        if(x == this.posX && y == this.posY - 1){
            return true;
        }
        if(x == this.posX + 1 && y == this.posY + 1){
            return true;
        }
        if(x == this.posX + 1 && y == this.posY - 1){
            return true;
        }
        if(x == this.posX - 1 && y == this.posY + 1){
            return true;
        }
        if(x == this.posX - 1 && y == this.posY - 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean obstacle(int x, int y){
        return true;
    };
}