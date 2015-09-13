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

    public static void main(String[] args) throws IOException {
        MainApp app = new MainApp();
        app.showMainMenu();
        String input = inputScanner.next();
        app.selectMenu(input);
    }

    private void showMainMenu() {
        System.out.println("Select option to choose game: ");
        System.out.println("1 : Maze Coordinate");
        System.out.println("2 : Maze Explore");
        System.out.println("My selection option: ");
    }

    private void selectMenu(String input) {
        switch (input) {
            case "1":
                System.out.println("Maze started, input 'q' to quit, 'm' to go back main menu");
                startFileMaze();
                break;

            case "2":
                System.out.println("Maze explorer started, input 'q' to quit, 'm' to go back main menu");
                startMazeExplorer();
                break;

            case "q":
                System.out.println("Quit Maze... bye bye");
                inputScanner.close();
                System.exit(0);

            case "m":
                showMainMenu();
                break;
            default:
                System.out.println("Menu option available: 1, 2, q, m");
        }
    }

    private void startFileMaze() {
        MazeBuilder mazeBuilder = new FileMaze();
        char[][] mazeGrid = mazeBuilder.build();
        mazeBuilder.printInfo();

        while (true) {
            System.out.print("Enter coordinate (example: x,y): ");
            String input = inputScanner.next();
            Point point = MazeUtil.getPointFromInput(input, mazeGrid);
            if (point.x >= 0) {
                System.out.println("Character in maze grid: [" + mazeGrid[point.x][point.y] + "]\n");
            }

        }
    }

    private void startMazeExplorer() {
        MazeBuilder mazeBuilder = new FileMaze();
        char[][] mazeGrid = mazeBuilder.build();
        System.out.println("Enter starting coordinate (example: x,y):");
        String input = inputScanner.next();
        Point point = MazeUtil.getPointFromInput(input, mazeGrid);
        if (point.x >= 0) {
            KeyExplorer explorer = new KeyExplorer(mazeGrid, point);

            while (true) {
                System.out.println("\nSelect your next movement, 'u':Up, 'd':Down, 'l':Left, 'r':Right (example: u)");
                String movement = inputScanner.next();

                switch (movement) {
                    case "u":
                        new MoveUp(explorer).move();
                        explorer.printCurrentPoint();
                        break;

                    case "d":
                        new MoveDown(explorer).move();
                        explorer.printCurrentPoint();
                        break;
                    case "l":
                        new MoveLeft(explorer).move();
                        explorer.printCurrentPoint();
                        break;
                    case "r":
                        new MoveRight(explorer).move();
                        explorer.printCurrentPoint();
                        break;
                    default:
                        System.out.println("ALERT: Wrong input. Option available: [u] [d] [l] [r]");
                }

            }
        } else {
            //TODO loop input again
            System.out.println("Wrong input");
        }

    }

}
