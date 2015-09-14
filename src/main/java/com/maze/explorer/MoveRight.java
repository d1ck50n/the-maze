package com.maze.explorer;

import com.maze.util.MazeUtil;
import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public class MoveRight extends Movement {

    private final KeyExplorer explorer;

    public MoveRight(KeyExplorer keyExplorer) {
        this.explorer = keyExplorer;
    }

    @Override
    public void move() {
        Point point = explorer.getCurrentPoint();
        if (point.x + 1 < explorer.getMaxGridX()) {
            point.x++;
            Point newPoint = new Point(point.x, point.y);
            explorer.setCurrentPoint(newPoint);
            explorer.addMovementHistory(KeyExplorer.MOVE.RIGHT, newPoint);
            super.printCurrentCoordinate(newPoint);
            super.printGridInfront(explorer);
            super.printAvailableMove(explorer);

        } else {
            MazeUtil.print("You are at the most right of wall, not allow to move right");
        }
    }

}
