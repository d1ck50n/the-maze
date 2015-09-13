package com.maze.explorer;

import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public class MoveUp implements Movement {

    private final KeyExplorer explorer;

    public MoveUp(KeyExplorer keyExplorer) {
        this.explorer = keyExplorer;
    }

    @Override
    public void move() {
        Point point = explorer.getCurrentPoint();
        char[][] mazeGrid = explorer.getMazeGrid();
        if (point.y + 1 < explorer.getMaxGridY()) {
            point.y++;
            System.out.println("[" + mazeGrid[point.x][point.y] + "] infront of you");
            Point newPoint = new Point(point.x, point.y);
            explorer.setCurrentPoint(newPoint);
            explorer.addMovement(KeyExplorer.MOVE.UP, newPoint);

        } else {
            System.out.println("You are at the top of wall, not allow to move down");
        }
    }

}
