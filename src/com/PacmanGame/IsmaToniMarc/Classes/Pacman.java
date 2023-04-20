package com.PacmanGame.IsmaToniMarc.Classes;

import com.PacmanGame.IsmaToniMarc.UI.Board;

/**
 * És una subclasse de Entity, que hereda valors com la x i la y.
 * Té més atributs:
 * Un contador de puntuació
 * Un contador de vides
 *
 */
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


    /**
     * És un metode que permet moure el Pacman per el tauler, primer comprovant que les direccions
     * on volem anar siguin valides, després quan es mou el pacman deixa un espai en blan per on pasa.
     * @param x Posició X on està ubicat el Pacman
     * @param y Posició Y on està ubicat el Pacman
     * @param board Cridem al objecte taular
     * @param direction És el paràmetre que indica la direcció on es vol anar amb el Pacman
     */
    public void move(int x, int y, Board board, char direction) {
        x = entityCurrentXPos(board, 'P');
        y = entityCurrentYPos(board, 'P');

        switch (direction) {
            case 'A':
                if (board.getGameBoard()[x][y - 1] == 'G' ||
                        board.getGameBoard()[x][y - 1] == 'R') {
                    System.out.println("HAS MORT!!!!");
                    System.exit(1011010);
                }
                //Move left
                if (checkValidPos(x, y - 1, board)) {
                    if (board.getGameBoard()[x][y - 1] == '·') {
                        pointCounter++;
                    }
                    board.getGameBoard()[x][y - 1] = 'P';
                    board.getGameBoard()[x][y] = ' ';

                }
                break;

            case 'D':
                if (board.getGameBoard()[x][y + 1] == 'G' ||
                        board.getGameBoard()[x][y + 1] == 'R') {
                    System.out.println("HAS MORT!!!!");
                    System.exit(1011010);
                }
                //Move right
                if (checkValidPos(x, y + 1, board)) {
                    if (board.getGameBoard()[x][y + 1] == '·') {
                        pointCounter++;
                    }
                    board.getGameBoard()[x][y + 1] = 'P';
                    board.getGameBoard()[x][y] = ' ';
                }
                break;

            case 'W':
                if (board.getGameBoard()[x - 1][y] == 'G' ||
                    board.getGameBoard()[x - 1][y] == 'R') {
                    System.out.println("HAS MORT!!!!");
                    System.exit(1011010);
                }
                //Move up
                if (checkValidPos(x - 1, y, board)) {
                    if (board.getGameBoard()[x -1][y] == '·') {
                        pointCounter++;
                    }

                    board.getGameBoard()[x - 1][y] = 'P';
                    board.getGameBoard()[x][y] = ' ';

                }
                break;

                case 'S':
                    if (board.getGameBoard()[x + 1][y] == 'G' ||
                        board.getGameBoard()[x + 1][y] == 'R') {
                        System.out.println("HAS MORT!!!!");
                        System.exit(1011010);
                    }
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
     * Mètode que retorna la posció X del valor char que li pasem com a entrada al mètode
     * @param board agafa un objecte tauler que és un array bidimensional de 11 x 9
     * @param player agafa el char que volem buscar al array, P = pacman, G i R = Fantasmes
     * @return retorna la posició X que busquem del char
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


    /**
     * Mètode que retorna la posció Y del valor char que li pasem com a entrada al mètode
     * @param board agafa un objecte tauler que és un array bidimensional de 11 x 9
     * @param player agafa el char que volem buscar al array, P = pacman, G i R = Fantasmes
     * @return retorna la posició Y que busquem del char
     */
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

    /**
     * Mètode que mostra la puntuació de la partida, amb el mètode get de la variable PointCounter
     */
    public void showCounter(){
        System.out.println("Puntuacio: "+ getPointCounter());
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
