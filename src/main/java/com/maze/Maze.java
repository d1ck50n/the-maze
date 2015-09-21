package com.maze;

import com.maze.util.MazeUtil;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dicksonk
 */
public class Maze {

    protected final Scanner inputScanner = new Scanner(System.in);

    protected void checkIfQuitOrMenu(String input, List<String> historyList) {
        checkMenu(input, historyList);
    }

    protected void checkIfQuitOrMenu(String input) {
        checkMenu(input, null);
    }

    protected void selectMenu(String input) {
        switch (input) {
            case "1":
                MazeUtil.print("\nMaze started, type 'quit' to quit game, 'menu' to go back main menu\n");
                new MazeCoordinate().start();
                break;

            case "2":
                new MazeExplorer().start();
                break;

            default:
                MazeUtil.print("Menu option available: 1, 2");
        }
    }

    protected void showMainMenu() {
        MazeUtil.print("\nChoose game (1 or 2): ");
        MazeUtil.print("1 : Maze Coordinate");
        MazeUtil.print("2 : Maze Explore");
        MazeUtil.print("\nI want to play: ");
        String menuInput = this.inputScanner.next();
        selectMenu(menuInput);
    }

    private void checkMenu(String input, List<String> historyList) {
        switch (input) {
            case "menu":
                showMainMenu();

            case "quit":
                MazeUtil.print("\nQuit Maze... bye bye\n");
                if (historyList != null) {
                    printRoute(historyList);
                }
                inputScanner.close();
                System.exit(0);
        }
    }

    private void printRoute(List<String> historyList) {
        MazeUtil.print("Sumarry of your route: \n");
        for (String route : historyList) {
            MazeUtil.print(route);
        }
    }
}
