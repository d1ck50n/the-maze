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
        MazeUtil.print("Select option to choose game: ");
        MazeUtil.print("1 : Maze Coordinate");
        MazeUtil.print("2 : Maze Explore");
        MazeUtil.print("My selection option: ");
    }

    private void selectMenu(String input) {
        switch (input) {
            case "1":
                MazeUtil.print("Maze started, input 'q' to quit, 'm' to go back main menu");
                startFileMaze();
                break;

            case "2":
                MazeUtil.print("Maze explorer started, input 'q' to quit, 'm' to go back main menu");
                startMazeExplorer();
                break;

            case "q":
                MazeUtil.print("Quit Maze... bye bye");
                inputScanner.close();
                System.exit(0);

            case "m":
                showMainMenu();
                break;
            default:
                MazeUtil.print("Menu option available: 1, 2, q, m");
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
                MazeUtil.print("Character in maze grid: [" + mazeGrid[point.x][point.y] + "]\n");
            }

        }
    }

    private void startMazeExplorer() {
        MazeBuilder mazeBuilder = new FileMaze();
        char[][] mazeGrid = mazeBuilder.build();
        MazeUtil.print("Enter starting coordinate (example: x,y):");
        String input = inputScanner.next();
        Point point = MazeUtil.getPointFromInput(input, mazeGrid);
        if (point.x >= 0) {
            KeyExplorer explorer = new KeyExplorer(mazeGrid, point);

            while (true) {
                MazeUtil.print("\nSelect your next movement, 'u':Up, 'd':Down, 'l':Left, 'r':Right (example: u)");
                String movement = inputScanner.next();

                switch (movement) {
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
        } else {
            //TODO loop input again
            MazeUtil.print("Wrong input");
        }

    }

}
