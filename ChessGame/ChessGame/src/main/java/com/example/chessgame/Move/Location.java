package com.example.chessgame.Move;

public class Location {
    // --- VARIABLE ---
    private int posX = 0;
    private int posY = 0;

    // --- CONSTRUCTOR ---
    public Location(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    // --- GETTER, SETTER ---
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setXY(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    public boolean destination(int x, int y){
        return true;
    }

}
