package com.maze.explorer;

import com.maze.util.MazeUtil;
import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public class MoveDown extends Movement {

    private final KeyExplorer explorer;

    public MoveDown(KeyExplorer keyExplorer) {
        this.explorer = keyExplorer;
    }

    @Override
    public void move() {
        Point point = explorer.getCurrentPoint();
        if (point.y - 1 >= 0) {
            point.y--;
            Point newPoint = new Point(point.x, point.y);
            explorer.setCurrentPoint(newPoint);
            explorer.addMovementHistory(KeyExplorer.MOVE.DOWN, newPoint);
            super.printCurrentCoordinate(newPoint);
            super.printGridInfront(explorer);
            super.printAvailableMove(explorer);

        } else {
            MazeUtil.print("You are at the bottom of wall, not allow to move down");
        }
    }

}
