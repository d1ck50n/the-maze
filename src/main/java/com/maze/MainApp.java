package com.maze;

import com.maze.builder.FileMaze;
import com.maze.builder.MazeBuilder;
import com.maze.explorer.KeyExplorer;
import com.maze.explorer.MoveDown;
import com.maze.explorer.MoveLeft;
import com.maze.explorer.MoveRight;
import com.maze.explorer.MoveUp;
import com.maze.util.MazeUtil;
import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dicksonk
 */
public class MainApp {

    private static final Scanner inputScanner = new Scanner(System.in);
    private KeyExplorer explorer;

    public static void main(String[] args) throws IOException {
        MainApp app = new MainApp();
        app.showMainMenu();
        String input = inputScanner.next();
        app.selectMenu(input);
    }

    private void showMainMenu() {
        MazeUtil.print("\nChoose game (1 or 2): ");
        MazeUtil.print("1 : Maze Coordinate");
        MazeUtil.print("2 : Maze Explore");
        MazeUtil.print("\nI want to play: ");
    }

    private void selectMenu(String input) {
        switch (input) {
            case "1":
                MazeUtil.print("\nMaze started, type 'quit' to quit game, 'menu' to go back main menu\n");
                startFileMaze();
                break;

            case "2":
                MazeUtil.print("\nMaze explorer started, type 'quit' to quit game, 'menu' to go back main menu\n");
                startMazeExplorer();
                break;

            default:
                MazeUtil.print("Menu option available: 1, 2");
        }
    }

    private void checkIfQuitOrMenu(String input) {
        switch (input) {
            case "menu":
                showMainMenu();
                String menuInput = inputScanner.next();
                selectMenu(menuInput);

            case "quit":
                MazeUtil.print("\nQuit Maze... bye bye\n");
                printRoute();
                inputScanner.close();
                System.exit(0);
        }
    }

    private void startFileMaze() {
        MazeBuilder mazeBuilder = new FileMaze();
        char[][] mazeGrid = mazeBuilder.build();
        mazeBuilder.printInfo();

        while (true) {
            System.out.print("\nEnter coordinate (example: x,y): ");
            String input = inputScanner.next();
            checkIfQuitOrMenu(input);
            Point point = MazeUtil.getPointFromInput(input, mazeGrid);
            if (point.x >= 0) {
                char currentGrid = mazeGrid[point.x][point.y];
                switch (currentGrid) {
                    case 'S':
                        MazeUtil.print("Character in maze grid: [START POINT 'S']\n");
                        break;
                    case 'F':
                        MazeUtil.print("Character in maze grid: [EXIT POINT 'F']\n");
                        break;
                    default:
                        MazeUtil.print("Character in maze grid: [" + mazeGrid[point.x][point.y] + "]\n");
                }
            }
        }
    }

    private void startMazeExplorer() {
        MazeBuilder mazeBuilder = new FileMaze();
        char[][] mazeGrid = mazeBuilder.build();
        Point point = MazeUtil.getDefaultPoint(mazeGrid);

        explorer = new KeyExplorer(mazeGrid, point);

        while (true) {
            MazeUtil.print("\nSelect your next movement, 'u':Up, 'd':Down, 'l':Left, 'r':Right (example: u)");
            String movementInput = inputScanner.next();
            checkIfQuitOrMenu(movementInput);
            switch (movementInput) {
                case "u":
                    new MoveUp(explorer).move();
                    break;

                case "d":
                    new MoveDown(explorer).move();
                    break;

                case "l":
                    new MoveLeft(explorer).move();
                    break;

                case "r":
                    new MoveRight(explorer).move();
                    break;

                default:
                    MazeUtil.print("ALERT: Wrong input. Option available: [u] [d] [l] [r]");
            }
        }
    }

    private void printRoute() {
        MazeUtil.print("Sumarry of your route: \n");
        for (String route : explorer.getMovementHistoryList()) {
            MazeUtil.print(route);
        }
    }

}
