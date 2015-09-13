package com.maze.explorer;

/**
 *
 * @author Dickson Kho Sep 13, 2015
 */
public interface Movement {

    public static enum ACTION {

        FORWARD, BACK, LEFT, RIGHT
    }

    void move();
}
