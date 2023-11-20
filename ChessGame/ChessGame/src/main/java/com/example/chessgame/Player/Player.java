package com.example.chessgame.Player;

public class Player {
    // --- VARIABLE ---
    private boolean human = false;
    private boolean white = false;
    private boolean black = false;
    private boolean turn = false;

    // --- CONSTRUCTOR ---
    public Player(){
    }
    // --- GETTER, SETTER ---
    // ----------------------
    public boolean isHuman() {return human;}
    public boolean isWhite() {return white;}
    public boolean isBlack() {return black;}
    public boolean isTurn() {return turn;}
    // ---------------------

    public void setTurn(boolean turn) {this.turn = turn;}


    // --- METHODS ---

}
