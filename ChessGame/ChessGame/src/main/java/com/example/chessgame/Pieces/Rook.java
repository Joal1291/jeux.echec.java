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
    public boolean obstacle(int x, int y,  int newX, int newY){
        if (x < 0 || x > 7 || y < 0 || y > 7) return false;
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7 ) return false;
        if(this.posX != x && this.posY ==y){
            if(this.posX > x){ // droite vers gauche
                for(int i=this.posX-1;i>x;i--){

                    if(!chessboard.getSquare(i, y).isFreeCase()){
                        return false;
                    }
                }
                return true;
            }
            else { // droite vers gauche
                for(int i=this.posX+1;i<x;i++){

                    if(!chessboard.getSquare(i, y).isFreeCase()){
                        return false;
                    }
                }
                return true;
            }
        }
        if(this.posY != y && this.posX == x){
            if(this.posY > y){ // bas vers haut
                for(int i=this.posY-1;i>y;i--){

                    if(!chessboard.getSquare(x, i).isFreeCase()){
                        return false;
                    }
                }
                return true;
            }
            else { // haut vers bas
                for(int i=this.posY+1;i<y;i++){

                    if(!chessboard.getSquare(x, i).isFreeCase()){
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    };
}
