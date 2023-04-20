package com.PacmanGame.IsmaToniMarc.Engine;

import com.PacmanGame.IsmaToniMarc.Classes.Ghost;
import com.PacmanGame.IsmaToniMarc.Classes.Pacman;
import com.PacmanGame.IsmaToniMarc.UI.Board;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    private Board board = new Board();
    private Pacman pacman = new Pacman(2, 5);
    private Ghost ghost1 = new Ghost(6,4);
    private Ghost ghost2 = new Ghost(6, 6);
    Scanner keyboard = new Scanner(System.in);
    private boolean playing = true;

    public static char triar;

    public Game() throws IOException {
        startGameLoop();
    }

    /**
     *
     * @throws IOException
     */
    private void startGameLoop() throws IOException {
        System.out.println("----------PACMAN----------");
        System.out.println("Començar partida nova (1) o continuar partida guardada (2)?");

        while (isPlaying()) {

            int choice = keyboard.nextInt();

            if (choice == 1) {
                board.readFile("C:\\IdeaProjects\\Pacman_JAVA_Game_MIT\\src\\com\\PacmanGame\\IsmaToniMarc\\Files\\Maps\\full_pacman_map.txt");
                board.printBoard();
                mainLoop();
                setPlaying(false);
            }
            else if (choice == 2) {
                board.readFile("C:\\IdeaProjects\\Pacman_JAVA_Game_MIT\\src\\com\\PacmanGame\\IsmaToniMarc\\Files\\Maps\\ingame_map.txt");
                board.printBoard();
                mainLoop();
                setPlaying(false);
            }
        }
    }

    public void mainLoop() throws IOException {

        do {
            System.out.print("Escull direcció A W S D  (Escriu H per guardar) ");
            triar = keyboard.next().toUpperCase().charAt(0);

            pacman.move(0, 0, board, triar);
            ghost1.move(board, 'G');
            ghost2.move(board, 'R');
            board.printBoard();


            if (triar == 'H') {
                board.writeFile("C:\\IdeaProjects\\Pacman_JAVA_Game_MIT\\src\\com\\PacmanGame\\IsmaToniMarc\\Files\\Maps\\ingame_map.txt");
            }

        }while (triar != 'X');
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
