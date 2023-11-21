package com.example.chessgame.ChessBoard;

import com.example.chessgame.Pieces.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Objects;

public class ChessBoard extends GridPane {

    // --- VARIABLES ---
    private Square departureSquare = null;
    private Square destinationSquare = null;

    private boolean clicked = false;

    private final ArrayList<Pieces> whitePieces = new ArrayList<Pieces>();
    private final ArrayList<Pieces> blackPieces = new ArrayList<Pieces>();
    private final ArrayList<Pieces> whitePiecesTaken = new ArrayList<Pieces>();
    private final ArrayList<Pieces> blackPiecesTaken = new ArrayList<Pieces>();

    private final Square[][] square = new Square[8][8];
    private final String[][] valueCase = {
            {"A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8"},
            {"A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7"},
            {"A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6"},
            {"A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5"},
            {"A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4"},
            {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3"},
            {"A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2"},
            {"A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1"},
    };
    // --- CONSTRUCTOR ---
    public ChessBoard() {
        drawBoard();
        putPiecesOnList();

        for(Pieces piece : whitePieces){
            getSquare(piece.getPosX(), piece.getPosY()).displayPiece();
        }
        for(Pieces piece : blackPieces){
            getSquare(piece.getPosX(), piece.getPosY()).displayPiece();
        }
        setOnMouseClicked(event -> handleClick());
    }
    // ------------------------------ GETTER, SETTER --------------------
    // ----- getter -----
    public ArrayList<Pieces> getWhitePieces(){return this.whitePieces;}
    public ArrayList<Pieces> getBlackPieces() {return this.blackPieces;}
    public ArrayList<Pieces> getWhitePiecesTaken() {return this.whitePiecesTaken;}
    public ArrayList<Pieces> getBlackPiecesTaken() {return this.blackPiecesTaken;}

    public Square getDepartureSquare(){return this.departureSquare;}
    public Square getDestinationSquare(){return this.destinationSquare;}
    public Square getSquare(int x, int y){
        return this.square[x][y];
    }
    public boolean getClicked(){return this.clicked;}
    // ----- setter -----
    public void setDepartureSquare(int x, int y){this.departureSquare = getSquare(x, y);}
    public void setDestinationSquare(int x, int y){this.destinationSquare = getSquare(x, y);}
    public void setClicked(boolean bool){this.clicked = bool;}

    // ------------------------------------- METHODS -----------------------------------
    private void drawBoard() {
        for (int row = 0; row < square.length; row++) { // foreach row
            for (int col = 0; col < square[row].length; col++) { // foreach col
                if((col+row) % 2 == 0){
                    square[row][col] = new Square(Color.BROWN, this);
                }else{
                    square[row][col] = new Square(Color.GRAY, this);
                }
                square[row][col].setPosXY(row, col);
                square[row][col].setPos(valueCase[row][col]);
                add(square[row][col], col, row);
            }
        }
    }
    private void initPiece(Pieces piece, String valueofCase){
        for (int row = 0; row < valueCase.length; row ++){
            for (int col = 0; col < valueCase[row].length; col++){
                if (valueofCase.equals(String.valueOf(valueCase[row][col]))){
                    piece.setPosXY(row, col);
                    piece.setPosValue(valueofCase);
                    getSquare(row, col).setFreeCase(false);
                    getSquare(row, col).setPiece(piece);
                    addPiecesToList(piece);
                }
            }
        }
    }
    private void putPiecesOnList(){
        initPiece(new King("white", this), "E1");
        initPiece(new King("black", this), "E8");

        initPiece(new Queen("white", this), "D1");
        initPiece(new Queen("black", this), "D8");

        initPiece(new Rook("white", this), "A1");
        initPiece(new Rook("white", this), "H1");
        initPiece(new Rook("black", this), "H8");
        initPiece(new Rook("black", this), "A8");

        initPiece(new Knight("white", this), "B1");
        initPiece(new Knight("white", this), "G1");
        initPiece(new Knight("black", this), "G8");
        initPiece(new Knight("black", this), "B8");

        initPiece(new Bishop("white", this), "C1");
        initPiece(new Bishop("white", this), "F1");
        initPiece(new Bishop("black", this), "F8");
        initPiece(new Bishop("black", this), "C8");

        initPiece(new Pawn("white", this), "A2");
        initPiece(new Pawn("white", this), "B2");
        initPiece(new Pawn("white", this), "C2");
        initPiece(new Pawn("white", this), "D2");
        initPiece(new Pawn("white", this), "E2");
        initPiece(new Pawn("white", this), "F2");
        initPiece(new Pawn("white", this), "G2");
        initPiece(new Pawn("white", this), "H2");

        initPiece(new Pawn("black", this), "A7");
        initPiece(new Pawn("black", this), "B7");
        initPiece(new Pawn("black", this), "C7");
        initPiece(new Pawn("black", this), "D7");
        initPiece(new Pawn("black", this), "E7");
        initPiece(new Pawn("black", this), "F7");
        initPiece(new Pawn("black", this), "G7");
        initPiece(new Pawn("black", this), "H7");
    }
    private void addPiecesToList(Pieces piece){
        if(Objects.equals(piece.getColor(), "white")){
            whitePieces.add(piece);
        }else{
            blackPieces.add(piece);
        }
    }
    public void clearDestination(){
        this.destinationSquare = null;
    }
    public void clearDeparture(){
        this.departureSquare = null;
    }
    public void handleClick(){
    };
}
