/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author dicksonk
 */
public class MazeExplorer extends Maze {

    protected void start() {
        MazeUtil.print("\nMaze explorer started, type 'quit' to quit game, 'menu' to go back main menu\n");
        MazeBuilder mazeBuilder = new FileMaze();
        char[][] mazeGrid = mazeBuilder.build();
        Point point = MazeUtil.getDefaultPoint(mazeGrid);

        KeyExplorer explorer = new KeyExplorer(mazeGrid, point);

        while (true) {
            MazeUtil.print("\nSelect your next movement, 'u':Up, 'd':Down, 'l':Left, 'r':Right (example: u)");
            String movementInput = super.inputScanner.next();
            super.checkIfQuitOrMenu(movementInput, explorer.getMovementHistoryList());
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
}
