package com.example.chessgame.ChessBoard;

import com.example.chessgame.ChessGame;
import com.example.chessgame.Pieces.Pieces;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Square extends Pane {
    // --- VARIABLES ---
    private boolean freeCase = true;
    private Pieces piece = null;
    public String pos;
    private int posX;
    private int posY;

    private final Color color;
    private final ChessBoard chessBoard;

    // --- CONSTRUCTOR ---
    public Square(Color color , ChessBoard chessBoard){
        this.color = color;
        this.chessBoard = chessBoard;
        drawCase(color);
        setOnMouseClicked(event -> selectSquare());
    }
    // ------------- GETTER, SETTER -------------
    // ---------------------
    public Pieces getPiece() {return piece;}
    public boolean isFreeCase() {return freeCase;}
    public String getPos(){return pos;}
    public int getPosX() {return posX;}
    public int getPosY() {return posY;}
    //----------------------
    public void setPiece(Pieces piece){
        this.piece = piece;
    }
    public void setFreeCase(boolean bool){
        this.freeCase = bool;
    }
    public void setPos(String pos){this.pos = pos;}
    public void setPosXY(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    // --- METHODS ---
    public void drawCase(Color color){
        Rectangle rectangle = new Rectangle(100, 100, color);
        getChildren().add(rectangle);
    }
    public void displayPiece(){
        if (piece != null) {
            getChildren().add(piece.getImageView());
            piece.getImageView().setFitWidth(100);
            piece.getImageView().setFitHeight(100);
        }
    }
    public void clearPiece(){
        this.piece = null;
        this.setFreeCase(true);
    }
    public void moveTo(){
                this.chessBoard.setDestinationSquare(posX, posY);

                Square destination = this.chessBoard.getDestinationSquare();
                Square departureSquare = this.chessBoard.getDepartureSquare();
                Pieces piece = this.chessBoard.getDepartureSquare().getPiece();

                if (piece.possibleMove(destination.posX, destination.posY) && piece.obstacle(departureSquare.posX, departureSquare.posY, destination.posX, destination.posY)) {
                    destination.setPiece(piece);
                    destination.setFreeCase(false);

                    departureSquare.clearPiece();
                    destination.displayPiece();
                    destination.getPiece().setPosXY(destination.posX, destination.posY);
                    if (Objects.equals(destination.getPiece().getType(), "pawn") || Objects.equals(destination.getPiece().getType(), "king")) {
                        destination.getPiece().setFirstmove(false);
                    }
                    this.chessBoard.clearDestination();
                    this.chessBoard.clearDeparture();
                } else {
                    System.out.println("impossible move");
                }
            this.chessBoard.setClicked(false);
        }
//    }
    public void takePiece(){

    }
    public void selectSquare(){
        Square checkSquare = this.chessBoard.getSquare(posX, posY);
        if (!this.chessBoard.getClicked()){
            if(!checkSquare.isFreeCase()) {
                this.chessBoard.setDepartureSquare(posX, posY);
                this.chessBoard.setClicked(true);
            }
        }else if(checkSquare == this.chessBoard.getDepartureSquare()){
            this.chessBoard.clearDeparture();
            this.chessBoard.setClicked(false);
        } else if(checkSquare != this.chessBoard.getDepartureSquare()){
            if (checkSquare.isFreeCase()){
                moveTo();
            }
        }
    }
}

