package com.PacmanGame.IsmaToniMarc.UI;

import com.PacmanGame.IsmaToniMarc.Engine.Constants;

import java.io.*;

public class Board {
    private char[][] gameBoard = new char[Constants.gameBoardHeight][Constants.gameBoardWidth];

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

    public void printBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public boolean win() {
//        for (int i = 0; i < gameBoard.length; i++) {
//            for (int j = 0; j < gameBoard[i].length; j++) {
//                if (gameBoard[i][j] == '·')
//                    return false;
//            }
//        }
//    }



    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }
}
