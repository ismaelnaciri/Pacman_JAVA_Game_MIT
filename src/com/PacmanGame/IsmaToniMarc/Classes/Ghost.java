package com.PacmanGame.IsmaToniMarc.Classes;

import com.PacmanGame.IsmaToniMarc.UI.Board;
import com.PacmanGame.IsmaToniMarc.Engine.Game;


public class Ghost extends Entity {

    public Ghost(int x, int y) {
        super(x, y);
    }


    public void move(Board board, char ghost) {

        int gPosX = entityCurrentXPos(board, ghost);
        int gPosY = entityCurrentYPos(board, ghost);

        int rPosX = entityCurrentXPos(board, ghost);
        int rPosY = entityCurrentXPos(board, ghost);

        int bPosX = entityCurrentXPos(board, ghost);
        int bPosY = entityCurrentYPos(board, ghost);


        switch (ghost) {
            case 'G':
                ghostMoves(gPosX, gPosY, ghost, board);
                break;
            case 'R':
                ghostMoves(rPosX, rPosY, ghost, board);
                break;
            case 'B':
                ghostMoves(bPosX, bPosY, ghost, board);
                break;
        }
    }

    public void ghostMoves(int x, int y, char ghost, Board board) {
        for (int i = 0; i < board.getGameBoard().length; i++) {
            for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                if (Game.triar == 'A') {
                    //Move left
                    if (checkValidPos(x, y, board)) {
                        board.getGameBoard()[x][y - 1] = ghost;
                        board.getGameBoard()[x][y] = ' ';
                    }
                }
                if (Game.triar == 'D') {
                    //Move right
                    if (checkValidPos(x, y, board)) {
                        board.getGameBoard()[x][y + 1] = ghost;
                        board.getGameBoard()[x][y] = ' ';
                    }
                }
                if (Game.triar == 'W') {
                    //Move up
                    if (checkValidPos(x, y, board)) {
                        board.getGameBoard()[x - 1][y] = ghost;
                        board.getGameBoard()[x][y] = ' ';
                    } else {
                        System.out.println("Not valid");
                    }
                }
                if (Game.triar == 'S') {
                    //Move down
                    if (checkValidPos(x, y, board)) {
                        board.getGameBoard()[x][y + 1] = ghost;
                        board.getGameBoard()[x][y] = ' ';
                    }
                }
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
