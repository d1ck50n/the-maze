/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze;

import com.maze.builder.FileMaze;
import com.maze.builder.MazeBuilder;
import com.maze.util.MazeUtil;
import java.awt.Point;

/**
 *
 * @author dicksonk
 */
public class MazeCoordinate extends Maze {

    protected void start() {
        MazeBuilder mazeBuilder = new FileMaze();
        char[][] mazeGrid = mazeBuilder.build();
        mazeBuilder.printInfo();

        while (true) {
            System.out.print("\nEnter coordinate (example: x,y): ");
            String input = inputScanner.next();
            super.checkIfQuitOrMenu(input);
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
}
