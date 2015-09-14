package com.maze.builder;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Dickson Kho Sep 15, 2015
 */
public class MazeBuilderTest {

    @Test
    public void testStartAndExitPoint() {
        char[][] fileMazeGrid = new FileMaze().build();
        int maxGridX = fileMazeGrid.length;
        int maxGridY = fileMazeGrid[0].length;
        final char START_POINT = 'S';
        final char EXIT_POINT = 'F';
        int startPointCounter = 0;
        int exitPointCounter = 0;

        for (int x = 0; x < maxGridX; x++) {
            for (int y = 0; y < maxGridY; y++) {
                if (fileMazeGrid[x][y] == START_POINT) {
                    startPointCounter++;
                }
                if (fileMazeGrid[x][y] == EXIT_POINT) {
                    exitPointCounter++;
                }
            }
        }
        Assert.assertEquals(1, startPointCounter);
        Assert.assertEquals(1, exitPointCounter);
    }
}
