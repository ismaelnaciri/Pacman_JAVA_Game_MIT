package com.PacmanGame.IsmaToniMarc.Classes;

import com.PacmanGame.IsmaToniMarc.UI.Board;

public abstract class Entity {

    private int x, y;

    Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y, Board board) {

    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public abstract void move(int x, int y, Board board, char direction);
}


