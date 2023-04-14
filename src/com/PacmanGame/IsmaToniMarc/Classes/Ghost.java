package com.PacmanGame.IsmaToniMarc.Classes;

import com.PacmanGame.IsmaToniMarc.UI.Board;

import java.util.Random;

public class Ghost extends Entity{

    public Ghost(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(int x, int y, Board board) {
        Random randomMove = new Random();

        switch (randomMove.nextInt(3)) {
            case 0:
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move left
                        if (board.getGameBoard()[x - 1][y] != '#' || board.getGameBoard()[x + 1][y] != 'G') {
                            board.getGameBoard()[x - 1][y] = 'G';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;

            case 1:
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move up
                        if (board.getGameBoard()[x][y - 1] != '#' || board.getGameBoard()[x + 1][y] != 'G') {
                            board.getGameBoard()[x][y - 1] = 'G';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move right
                        if (board.getGameBoard()[x + 1][y] != '#' || board.getGameBoard()[x + 1][y] != 'G') {
                            board.getGameBoard()[x + 1][y] = 'G';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }

            case 3:
                for (int i = 0; i < board.getGameBoard().length; i++) {
                    for (int j = 0; j < board.getGameBoard()[i].length; j++) {
                        //Move down
                        if (board.getGameBoard()[x][y + 1] != '#' || board.getGameBoard()[x][y + 1] != 'G') {
                            board.getGameBoard()[x][y + 1] = 'G';
                            board.getGameBoard()[x][y] = ' ';
                        }
                    }
                }
                break;
        }


    }
}
