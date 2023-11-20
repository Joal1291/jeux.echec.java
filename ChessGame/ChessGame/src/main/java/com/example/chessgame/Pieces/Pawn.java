package com.example.chessgame.Pieces;

import com.example.chessgame.ChessBoard.ChessBoard;
import com.example.chessgame.Move.Location;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Pawn extends Pieces{
    // -------------------------------- CONSTRUCTOR -------------------
    public Pawn(String color, ChessBoard chessboard){
        super("pawn", color, chessboard);
        this.image = new Image("/" + color + "_" + this.type + ".png");
        this.imageView = new ImageView(image);
        this.firstmove = true;
    }

    // ------------------------ METHODS ------------------------------
    @Override
    public boolean possibleMove(int x, int y){
        if (x < 0 || x > 7 || y < 0 || y > 7) return false;
        if(this.chessboard.getDepartureSquare() != null){
            if(this.firstmove){
                if(Objects.equals(this.color, "white")){
                    if (x == this.posX - 2 && y == this.posY){
                        return true;
                    }
                    if (x == this.posX - 1 && y == this.posY){
                        return true;
                    }
                    if (x == this.posX - 1 && y == this.posY + 1 || x == this.posX - 1 && y == this.posY - 1){
                        if (!this.chessboard.getDestinationSquare().isFreeCase() && Objects.equals(this.chessboard.getDestinationSquare().getPiece().getType(), "black")){
                            return true;
                        } else {
                            return false;
                        }
                    }
                }else{
                    if (x == this.posX + 2 && y == this.posY){
                        return true;
                    }
                    if (x == this.posX + 1 && y == this.posY){
                        return true;
                    }
                }
            }else{
                if (Objects.equals(this.color, "white")){
                    if (x == this.posX - 1 && y == this.posY){
                        return true;
                    }
                }else{
                    if (x == this.posX + 1 && y == this.posY){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public boolean obstacle(int x, int y,  int newX, int newY){
        return true;
    };
}
