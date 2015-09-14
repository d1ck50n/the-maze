package com.maze.explorer;

import com.maze.util.MazeUtil;
import java.awt.Point;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public class MoveUp extends Movement {

    private final KeyExplorer explorer;

    public MoveUp(KeyExplorer keyExplorer) {
        this.explorer = keyExplorer;
    }

    @Override
    public void move() {
        Point point = explorer.getCurrentPoint();
        if (point.y + 1 < explorer.getMaxGridY()) {
            point.y++;
            Point newPoint = new Point(point.x, point.y);
            explorer.setCurrentPoint(newPoint);
            explorer.addMovementHistory(KeyExplorer.MOVE.UP, newPoint);
            super.printCurrentCoordinate(newPoint);
            super.printGridInfront(explorer);
            super.printAvailableMove(explorer);

        } else {
            MazeUtil.print("You are at the top of wall, not allow to move up");
        }
    }

}
