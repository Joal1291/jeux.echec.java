package com.example.chessgame.Move;

public interface Move {
    public boolean possibleMove(int x, int y);
    public boolean obstacle(int x, int y);
//    public boolean takePiece(int x, int y);
}
