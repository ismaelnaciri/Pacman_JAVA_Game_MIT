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

    /**
     * Mètode que comprova que la posició on es desplaça el Pacman i els fantasmes son correctes
     * comprovant que no hi hagi ni una paret ni els fantasemes
     * @param x poscio X on es troba
     * @param y posicio Y on es troba
     * @param board tauler del joc
     * @return
     */
    public boolean checkValidPos(int x, int y, Board board) {
        if (board.getGameBoard()[x][y] == '#'
                || board.getGameBoard()[x][y] == 'G'
                || board.getGameBoard()[x][y] == 'R')
            return false;
        return true;
    }

    /**
     * Mètode abstracte que les subclses Pacman i Ghost haurà de tenir obligatoriamnet, per trobar la X d'aquests
     * @param board Tauler on es busca la posició X del Char
     * @param player Char del que busquem la X
     * @return retorna la posició X del Char
     */
    public abstract int entityCurrentXPos(Board board, char player);

    /**
     * Mètode abstracte que les subclses Pacman i Ghost haurà de tenir obligatoriamnet, per trobar la Y d'aquests
     * @param board Tauler on es busca la posició Y del Char
     * @param player Char del que busquem la Y
     * @return retorna la posició Y del Char
     */
    public abstract int entityCurrentYPos(Board board, char player);


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


