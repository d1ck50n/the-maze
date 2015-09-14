package com.maze.util;

import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public class MazeUtil {

    /**
     * Assert input and return Point <br>
     * Return Point(-1, -1) when exception occur
     *
     * @param input
     * @param mazeGrid
     * @return {@link Point}
     */
    public static Point getPointFromInput(String input, char[][] mazeGrid) {

        try {
            String[] inputArr = input.split(",");
            int x = Integer.parseInt(inputArr[0]);
            int y = Integer.parseInt(inputArr[1]);
            char tmp = mazeGrid[x][y];
            return new Point(x, y);

        } catch (ArrayIndexOutOfBoundsException e) {
            MazeUtil.print("ALERT: Please enter grid within [" + mazeGrid.length + "][" + mazeGrid[0].length + "]\n");

        } catch (RuntimeException re) {
            MazeUtil.print("Incorrect coordinate format, example: x,y");
        }
        return new Point(-1, -1);
    }

    /**
     * Get default starting point which mark as 'S' in the maze
     *
     * @param mazeGrid
     * @return
     */
    public static Point getDefaultPoint(char[][] mazeGrid) {
        int maxGridX = mazeGrid.length;
        int maxGridY = mazeGrid[0].length;
        for (int x = 0; x < maxGridX; x++) {
            for (int y = 0; y < maxGridY; y++) {
                if (mazeGrid[x][y] == 'S') {
                    MazeUtil.print("\nYou started at [" + x + "][" + y + "]");
                    return new Point(x, y);
                }
            }
        }
        return new Point(-1, -1);
    }

    public static void print(String output) {
        System.out.println(output);
    }
}
