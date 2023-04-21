package com.PacmanGame.IsmaToniMarc.Classes;

import com.PacmanGame.IsmaToniMarc.UI.Board;
import com.PacmanGame.IsmaToniMarc.Engine.Game;

import java.util.Random;


public class Ghost extends Entity {

    public Ghost(int x, int y) {
        super(x, y);
    }

    /**
     * Creació de la classe random per poder fer els moviments dels fantasmes aleatoris
     */
    private Random randomG = new Random(System.currentTimeMillis());
    private Random randomR = new Random(System.currentTimeMillis());
    public void move(Board board, char ghost) {

        int gPosX = entityCurrentXPos(board, ghost);
        int gPosY = entityCurrentYPos(board, ghost);

        int rPosX = entityCurrentXPos(board, ghost);
        int rPosY = entityCurrentYPos(board, ghost);

        int tempG = randomG.nextInt(4);
        int tempR = randomR.nextInt(4);

        switch (ghost) {
            case 'G':
                ghostMoves(gPosX, gPosY, ghost, board, tempG);
                break;
            case 'R':
                ghostMoves(rPosX, rPosY, ghost, board, tempR);
                break;
        }
    }

    public void ghostMoves(int x, int y, char ghost, Board board, int move) {
        if (move == 0) {
            //Move left
            if (checkValidPos(x, y - 1, board)) {
                board.getGameBoard()[x][y - 1] = ghost;
                board.getGameBoard()[x][y] = ' ';
            }
        }
        if (move == 2) {
            //Move right
            if (checkValidPos(x, y + 1, board)) {
                board.getGameBoard()[x][y + 1] = ghost;
                board.getGameBoard()[x][y] = ' ';
            }
        }

        if (move == 1) {
            //Move up
            if (checkValidPos(x - 1, y, board)) {
                board.getGameBoard()[x - 1][y] = ghost;
                board.getGameBoard()[x][y] = ' ';
            }
        }

        if (move == 3) {
            //Move down
            if (checkValidPos(x + 1, y, board)) {
                board.getGameBoard()[x + 1][y] = ghost;
                board.getGameBoard()[x][y] = ' ';
            }
        }
    }


    //Get B Pos x
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

    //Get B Pos Y
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
}
