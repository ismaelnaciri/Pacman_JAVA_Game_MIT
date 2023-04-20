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

    public boolean checkValidPos(int x, int y, Board board) {
        if (board.getGameBoard()[x - 1][y] != '#' && board.getGameBoard()[x - 1][y] != 'G'
        && board.getGameBoard()[x - 1][y] != 'R' && board.getGameBoard()[x - 1][y] != 'B')
            return false;
        if (board.getGameBoard()[x + 1][y] != '#' && board.getGameBoard()[x + 1][y] != 'G'
        && board.getGameBoard()[x + 1][y] != 'R' && board.getGameBoard()[x + 1][y] != 'B')
            return false;
        if (board.getGameBoard()[x][y - 1] != '#' && board.getGameBoard()[x][y - 1] != 'G'
        && board.getGameBoard()[x][y - 1] != 'R' && board.getGameBoard()[x][y - 1] != 'B')
            return false;
        if (board.getGameBoard()[x][y + 1] != '#' && board.getGameBoard()[x][y + 1] != 'G'
        && board.getGameBoard()[x][y + 1] != 'R' && board.getGameBoard()[x][y + 1] != 'B')
            return false;

        return true;
    }
    public int entityCurrentXPos(Board board, char player) {
        for (int i = 0; i < board.getGameBoard().length; i++) {
            for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                if (board.getGameBoard()[i][j] == player) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int entityCurrentYPos(Board board, char player) {
        for (int i = 0; i < board.getGameBoard().length; i++) {
            for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                if (board.getGameBoard()[i][j] == player) {
                    return i;
                }
            }
        }
        return 0;
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

}


