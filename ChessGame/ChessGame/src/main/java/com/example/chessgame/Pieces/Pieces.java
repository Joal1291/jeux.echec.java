package com.example.chessgame.Pieces;

import com.example.chessgame.ChessBoard.ChessBoard;
import com.example.chessgame.Move.Location;
import com.example.chessgame.Move.Move;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Pieces implements Move {
    // --- VARIABLES ---
    protected Image image;
    protected ImageView imageView;
    protected String type;
    protected String color;
    protected boolean firstmove = false;
    private String posValue;
    protected int posX;
    protected int posY;
    protected ChessBoard chessboard;


    // --- CONSTRUCTOR ---
    public Pieces(String type, String color, ChessBoard chessboard){
        this.type = type;
        this.color = color;
        this.chessboard = chessboard;
    }

    // --- GETTER, SETTER ---
    public ImageView getImageView(){return this.imageView;}
    public boolean isFirstmove() {
        return firstmove;
    }
    public int getPosY(){return this.posY;}
    public int getPosX(){return this.posX;}
    public String getPosValue(){return this.posValue;}
    public String getType() {
        return type;
    }
    public String getColor() {
        return color;
    }
    public void setFirstmove(boolean bool){
        this.firstmove = bool;
    }
    public void setPosXY(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    public void setPosValue(String location){
        this.posValue = location;
    }
    public void setColor(String value){
        this.color = value;
    }
//    public void setLocation(int x, int y){
//
//        location.setXY(x, y);
//    }

    // --- Methods ---

}
