package com.PacmanGame.IsmaToniMarc.Classes;

import com.PacmanGame.IsmaToniMarc.UI.Board;

public class Pacman extends Entity {

    private int lifes = 2;

    private boolean left, up, right, down;
    private char[][] pacmanPos;
    private int pointCounter = 1;

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
                //Move left
                if (checkValidPos(x, y - 1, board)) {
                    if (board.getGameBoard()[x][y - 1] == '·')
                        pointCounter++;
                    board.getGameBoard()[x][y - 1] = 'P';
                    board.getGameBoard()[x][y] = ' ';

                }
                break;

            case 'D':
                //Move right
                if (checkValidPos(x, y + 1, board)) {
                    if (board.getGameBoard()[x][y + 1] == '·')
                        pointCounter++;
                    board.getGameBoard()[x][y + 1] = 'P';
                    board.getGameBoard()[x][y] = ' ';
                }
                break;

            case 'W':
                //Move up
                if (checkValidPos(x - 1, y, board)) {
                    if (board.getGameBoard()[x -1][y] == '·')
                        pointCounter++;
                    board.getGameBoard()[x - 1][y] = 'P';
                    board.getGameBoard()[x][y] = ' ';

                }
                break;

                case 'S':
                    //Move DOWN
                    if (checkValidPos(x + 1, y, board)) {
                        if (board.getGameBoard()[x +1][y] == '·')
                            pointCounter++;
                        board.getGameBoard()[x + 1][y] = 'P';
                        board.getGameBoard()[x][y] = ' ';
                }
                break;
        }
    }

    /**
     * @param board
     * @param player
     * @return
     */
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


    public char[][] getPacmanPos() {
        return pacmanPos;
    }

    public void setPacmanPos(char[][] pacmanPos) {
        this.pacmanPos = pacmanPos;
    }

    public int getPointCounter() {
        return pointCounter;
    }

    public void setPointCounter(int pointCounter) {
        this.pointCounter = pointCounter;
    }
}
