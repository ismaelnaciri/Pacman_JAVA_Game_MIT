package com.PacmanGame.IsmaToniMarc.Classes;

import com.PacmanGame.IsmaToniMarc.UI.Board;

public class Pacman extends Entity {

    private int x, y;
    private boolean left, up, right, down;

    private char[][] pacmanPos;

    public Pacman(int x, int y) {
        super(x, y);
        setX(1);
        setY(1);
    }


    @Override
    public void move(int x, int y, Board board, char direction) {
        x = pacmanCurrentXPos(board);
        y = pacmanCurrentYPos(board);

        switch (direction) {
            case 'A':
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move left
                        if (board.getGameBoard()[x - 1][y] != '#' || board.getGameBoard()[x - 1][y] != 'G') {
                            board.getGameBoard()[x - 1][y] = 'P';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;

            case 'D':
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move right
                        if (board.getGameBoard()[x + 1][y] != '#' || board.getGameBoard()[x + 1][y] != 'G') {
                            board.getGameBoard()[x + 1][y] = 'P';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;

            case 'W':
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move up
                        if (board.getGameBoard()[x][y - 1] != '#' || board.getGameBoard()[x][y - 1] != 'G') {
                            board.getGameBoard()[x][y - 1] = 'P';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;

                case 'S':
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move DOWN
                        if (board.getGameBoard()[x][y + 1] != '#' || board.getGameBoard()[x][y - 1] != 'G') {
                            board.getGameBoard()[x][y + 1] = 'P';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;
        }
    }

    public int pacmanCurrentXPos(Board board) {
        for (int i = 0; i < board.getGameBoard().length; i++) {
            for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                if (board.getGameBoard()[i][j] == 'P') {
                    return i;
                }
            }
        }
        return 0;
    }

    public int pacmanCurrentYPos(Board board) {
        for (int i = 0; i < board.getGameBoard().length; i++) {
            for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                if (board.getGameBoard()[i][j] == 'P') {
                    return j;
                }
            }
        }
        return 0;
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
