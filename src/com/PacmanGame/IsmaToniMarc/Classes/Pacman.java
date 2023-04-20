package com.PacmanGame.IsmaToniMarc.Classes;

import com.PacmanGame.IsmaToniMarc.UI.Board;

public class Pacman extends Entity {

    private int x;
    private int y;

    private int lifes;

    private boolean left, up, right, down;
    private char[][] pacmanPos;

    public Pacman(int x, int y) {
        super(x, y);
        setX(1);
        setY(1);
    }

    public void move(int x, int y, Board board, char direction) {
        x = entityCurrentXPos(board, 'P');
        y = entityCurrentYPos(board, 'P');

        switch (direction) {
            case 'A':
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move left
                        if (checkValidPos(x, y, board)) {
                            board.getGameBoard()[x][y - 1] = 'P';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;

            case 'D':
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move right
                        if (checkValidPos(x, y, board)) {
                            board.getGameBoard()[x][y + 1] = 'P';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;

            case 'W':
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move up
                        if (checkValidPos(x, y, board)) {
                            board.getGameBoard()[x - 1][y] = 'P';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;

                case 'S':
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move DOWN
                        if (checkValidPos(x, y, board)) {
                            board.getGameBoard()[x + 1][y] = 'P';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;
        }
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
                    return j;
                }
            }
        }
        return 0;
    }


    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public void updateXPos(int x, int y) {

    }

    public void updateYPos(int x, int y) {

    }


    public char[][] getPacmanPos() {
        return pacmanPos;
    }

    public void setPacmanPos(char[][] pacmanPos) {
        this.pacmanPos = pacmanPos;
    }
}
