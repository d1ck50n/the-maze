package com.maze.explorer;

import com.maze.util.MazeUtil;
import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public abstract class Movement {

    public abstract void move();

    protected void updateExplorer(Point newPoint, KeyExplorer explorer, KeyExplorer.MOVE key) {
        explorer.addMovementHistory(key, newPoint);
        explorer.setCurrentPoint(newPoint);
        printCurrentCoordinate(newPoint);
        printGridInfront(explorer);
        printAvailableMove(explorer);
    }

    private void printCurrentCoordinate(Point point) {
        MazeUtil.print("Current coordinate: " + point.x + ", " + point.y);
    }

    private void printGridInfront(KeyExplorer explorer) {
        Point currentPoint = explorer.getCurrentPoint();
        if (currentPoint.y + 1 < explorer.getMaxGridY()) {
            MazeUtil.print("[" + explorer.getMazeGrid()[currentPoint.x][currentPoint.y + 1] + "] infront of you");

        } else {
            MazeUtil.print("You are now at top, no grid infront of you");
        }
    }

    private void printAvailableMove(KeyExplorer explorer) {
        Point currentPoint = explorer.getCurrentPoint();
        StringBuilder sb = new StringBuilder();
        sb.append("You are allow to move ");
        // set what is the grid infront of player
        if (currentPoint.y + 1 < explorer.getMaxGridY()) {
            sb.append("[UP] ");
        }

        if (currentPoint.y - 1 > 0) {
            sb.append("[DOWN] ");
        }

        // set available move from current location
        if (currentPoint.x + 1 < explorer.getMaxGridX()) {
            sb.append("[RIGHT] ");
        }

        if (currentPoint.x - 1 > 0) {
            sb.append("[LEFT] ");
        }

        // simply check if one of movement allow
        if (sb.indexOf("[") > 0) {
            MazeUtil.print(sb.toString());
        } else {
            MazeUtil.print("You are not allow to move elsewhere");
        }
    }
}
