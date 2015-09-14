package com.maze.explorer;

import com.maze.util.MazeUtil;
import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public class MoveLeft extends Movement {

    private final KeyExplorer explorer;

    public MoveLeft(KeyExplorer keyExplorer) {
        this.explorer = keyExplorer;
    }

    @Override
    public void move() {
        Point point = explorer.getCurrentPoint();
        if (point.x - 1 >= 0) {
            point.x--;
            Point newPoint = new Point(point.x, point.y);
            explorer.setCurrentPoint(newPoint);
            explorer.addMovementHistory(KeyExplorer.MOVE.LEFT, newPoint);
            super.printCurrentCoordinate(newPoint);
            super.printGridInfront(explorer);
            super.printAvailableMove(explorer);

        } else {
            MazeUtil.print("You are at the most left of wall, not allow to move left");
        }
    }

}
