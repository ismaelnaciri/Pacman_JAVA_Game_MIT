package com.PacmanGame.IsmaToniMarc.Engine;

import com.PacmanGame.IsmaToniMarc.Classes.Ghost;
import com.PacmanGame.IsmaToniMarc.Classes.Pacman;
import com.PacmanGame.IsmaToniMarc.UI.Board;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    /**
     * Creació objecte mapa
     */
    private Board board = new Board();

    /**
     * Creació objecte Pacman amb posicio X i Y definida per paràmetres
     */
    private Pacman pacman = new Pacman(2, 5);

    /**
     * Creació objecte Ghost amb posicio X i Y definida per paràmetres
     */
    private Ghost ghost1 = new Ghost(6,4);

    /**
     * Creació objecte Ghost amb posicio X i Y definida per paràmetres
     */
    private Ghost ghost2 = new Ghost(6, 6);

    /**
     * Crear objecte Teclat, del tipus Scanner per poder llegir paràmetres d'entrada
     */
    Scanner keyboard = new Scanner(System.in);

    /**
     * Boleà per definir quan acab el bucle de la partida
     */
    private boolean playing = true;

    public static char triar;

    public Game() throws IOException {
        startGameLoop();
    }

    /**
     * Un bucle While que a dins tenim la opció de triar crear una partida nova o continuar la partida guardada
     * A dins tenim metodes dels objectes board per poder llegir el mapa i mostra-lo
     * @throws IOException per capturar algun error que hi hagi
     */
    private void startGameLoop() throws IOException {
        System.out.println("----------PACMAN----------");
        System.out.println("Començar partida nova (1) o continuar partida guardada (2)?");

        while (isPlaying()) {

            int choice = keyboard.nextInt();

            if (choice == 1) {
                board.readFile("C:\\IdeaProjects\\Pacman_JAVA_Game_MIT\\src\\com\\PacmanGame\\IsmaToniMarc\\Files\\Maps\\full_pacman_map.txt");
                board.printBoard();
                board.putTotalPoints();
                mainLoop();
                setPlaying(false);
            }
            else if (choice == 2) {
                board.readFile("C:\\IdeaProjects\\Pacman_JAVA_Game_MIT\\src\\com\\PacmanGame\\IsmaToniMarc\\Files\\Maps\\ingame_map.txt");
                board.printBoard();
                board.putTotalPoints();
                System.out.println("test: " + board.getTotalPoints());
                mainLoop();
                setPlaying(false);
            }
        }
    }

    /**
     * Bucle principal per moure el pacman per el mapa, dins tenim mètodes
     * @throws IOException
     */
    public void mainLoop() throws IOException {

        do {
            System.out.print("Escull direcció A W S D  (Escriu H per guardar) ");
            triar = keyboard.next().toUpperCase().charAt(0);

            pacman.showCounter();
            pacman.move(0, 0, board, triar);
            ghost1.move(board, 'G');
            ghost2.move(board, 'R');
            board.printBoard();


            if (triar == 'H') {
                board.writeFile("C:\\IdeaProjects\\Pacman_JAVA_Game_MIT\\src\\com\\PacmanGame\\IsmaToniMarc\\Files\\Maps\\ingame_map.txt");
            }

        }while (pacman.getLifes() > 0 && board.getTotalPoints() > 0);
    }


    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public Ghost getGhost1() {
        return ghost1;
    }

    public void setGhost1(Ghost ghost1) {
        this.ghost1 = ghost1;
    }

    public Ghost getGhost2() {
        return ghost2;
    }

    public void setGhost2(Ghost ghost2) {
        this.ghost2 = ghost2;
    }

    public char getTriar() { return triar; }
    public void setTriar(char triar) { this.triar = triar; }
}
