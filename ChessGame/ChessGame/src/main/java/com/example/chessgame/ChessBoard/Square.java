package com.example.chessgame.ChessBoard;

import com.example.chessgame.ChessGame;
import com.example.chessgame.Pieces.Pieces;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
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

                if (piece.possibleMove(destination.posX, destination.posY) && piece.obstacle(destination.posX, destination.posY) && destination.isFreeCase()) {
                    destination.setPiece(piece);
                    destination.setFreeCase(false);
                    System.out.println("position de la piece: " + destination.posX + " " + destination.posY + " is free case ?: " + destination.isFreeCase());
                    departureSquare.clearPiece();
                    destination.displayPiece();
                    destination.getPiece().setPosXY(destination.posX, destination.posY);
                    if (Objects.equals(destination.getPiece().getType(), "pawn") || Objects.equals(destination.getPiece().getType(), "king") || Objects.equals(destination.getPiece().getType(), "rook")) {
                        destination.getPiece().setFirstmove(false);
                    }
                    this.chessBoard.clearDestination();
                    this.chessBoard.clearDeparture();
                } else if (piece.possibleMove(destination.posX, destination.posY) && piece.obstacle(destination.posX, destination.posY) && !destination.isFreeCase()){
                    takePiece(departureSquare, destination);
                }else{
                    System.out.println("impossible move");
                }
            this.chessBoard.setClicked(false);
        }
//    }
    public void addRemoveDisplay(Square departure, Pieces pieceOnDeparture, Square destination, Pieces pieceOnDestination){
    destination.getChildren().remove(pieceOnDestination.getImageView());
    destination.clearPiece();
    destination.setPiece(pieceOnDeparture);
    destination.setFreeCase(false);
    destination.displayPiece();
    destination.getPiece().setPosXY(destination.posX, destination.posY);
    departure.clearPiece();
}
    public void takePiece(Square departure, Square destination){
        Pieces pieceOnDestination = destination.getPiece();
        Pieces pieceOnDeparture = departure.getPiece();
        ArrayList<Pieces> white = this.chessBoard.getWhitePieces();
        ArrayList<Pieces> black = this.chessBoard.getBlackPieces();
        ArrayList<Pieces> blackTaken = this.chessBoard.getBlackPiecesTaken();
        ArrayList<Pieces> whiteTaken = this.chessBoard.getWhitePiecesTaken();

        if(departure.getPiece().getColor() == "white" && destination.getPiece().getColor() == "black") {
            System.out.println("prise blanche");
            black.remove(pieceOnDestination);
            blackTaken.add(pieceOnDestination);
            addRemoveDisplay(departure, pieceOnDeparture, destination, pieceOnDestination);
        }else if(departure.getPiece().getColor() == "black" && destination.getPiece().getColor() == "white"){
            System.out.println("prise noir");
            white.remove(pieceOnDestination);
            whiteTaken.add(pieceOnDestination);
            addRemoveDisplay(departure, pieceOnDeparture, destination, pieceOnDestination);
        }else{
            System.out.println("impossible take");
        }

        this.chessBoard.clearDestination();
        this.chessBoard.clearDeparture();
    }
    public void selectSquare(){
        Square checkSquare = this.chessBoard.getSquare(posX, posY);
        if (!this.chessBoard.getClicked()){
            if(!checkSquare.isFreeCase()) {
                this.chessBoard.setDepartureSquare(posX, posY);
                System.out.println("is free case ? : " + this.chessBoard.getDepartureSquare().isFreeCase());
                this.chessBoard.setClicked(true);
            }
        }else if(checkSquare == this.chessBoard.getDepartureSquare()){
            this.chessBoard.clearDeparture();
            this.chessBoard.setClicked(false);
        } else if(checkSquare != this.chessBoard.getDepartureSquare()){
            moveTo();
        }
    }

}

