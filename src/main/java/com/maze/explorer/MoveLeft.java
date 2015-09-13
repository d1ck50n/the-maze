package com.maze.explorer;

import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public class MoveLeft implements Movement {

    private final KeyExplorer explorer;

    public MoveLeft(KeyExplorer keyExplorer) {
        this.explorer = keyExplorer;
    }

    @Override
    public void move() {
        Point point = explorer.getCurrentPoint();
        char[][] mazeGrid = explorer.getMazeGrid();
        if (point.x - 1 >= 0) {
            point.x--;
            System.out.println("[" + mazeGrid[point.x][point.y] + "] infront of you");
            Point newPoint = new Point(point.x, point.y);
            explorer.setCurrentPoint(newPoint);
            explorer.addMovement(KeyExplorer.MOVE.LEFT, newPoint);

        } else {
            System.out.println("You are at the most left of wall, not allow to move left");
        }
    }

}
