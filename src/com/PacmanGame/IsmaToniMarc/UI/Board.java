package com.PacmanGame.IsmaToniMarc.UI;

import com.PacmanGame.IsmaToniMarc.Engine.Constants;

import java.io.*;

/**
 * És una classe que conté 2 atributs:
 * Un array bideomensional amb carateristiques size definides per unes constants
 * Atribut que a mesura que el pacman es menja una '.' augmenta
 */
public class Board {
    private char[][] gameBoard = new char[Constants.gameBoardHeight][Constants.gameBoardWidth];
    private int totalPoints = 0;

    /**
     * Mètode que llegeix el contigut d'un fitxer (mapa del joc) i 
     * guarda e cada poscio del array un caràcter, conté caths per poder detectar posibles errors
     * @param fileName Ruta del fitxer d'on llegim el mapa
     * @throws IOException Per controlar qualsevol exepció
     */
    public void readFile(String fileName) throws IOException {

        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                for (int j = 0; j < line.length(); j++) {
                    gameBoard[i][j] = line.charAt(j);
                }

                i += 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * És un mètode per guardar el estat de la partida, aquí utilitzem un bufferWriter per desar
     * els contiguts del array en un fitxer. A més a més utilizem catchs per detecar possibles problemes
     * @param fileName Ruta del fitxer on es guarden el canvis
     * @throws IOException Per controlar qualsevol exepció
     */
    public void writeFile(String fileName) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < gameBoard.length; i++) {
                for (int j = 0; j < gameBoard[0].length; j++) {
                    writer.write(gameBoard[i][j]);
                }
                writer.newLine();
            }
            writer.close();

            System.out.println("Partida guardada");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     *Mètode que conté un bucle per mostrar el tauler, afegeix un espai en
     * blanc entre cada posició per deixar-ho bé esteticament
     */
    public void printBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     */
    public void putTotalPoints() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == '·')
                    totalPoints++;
            }
        }
    }


    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

}
