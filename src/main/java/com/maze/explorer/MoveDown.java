package com.maze.explorer;

import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public class MoveDown implements Movement {

    private final KeyExplorer explorer;

    public MoveDown(KeyExplorer keyExplorer) {
        this.explorer = keyExplorer;
    }

    @Override
    public void move() {
        Point point = explorer.getCurrentPoint();
        char[][] mazeGrid = explorer.getMazeGrid();
        if (point.y - 1 >= 0) {
            point.y--;
            System.out.println("[" + mazeGrid[point.x][point.y] + "] infront of you");
            Point newPoint = new Point(point.x, point.y);
            explorer.setCurrentPoint(newPoint);
            explorer.addMovement(KeyExplorer.MOVE.DOWN, newPoint);

        } else {
            System.out.println("You are at the bottom of wall, not allow to move up");
        }
    }

}
