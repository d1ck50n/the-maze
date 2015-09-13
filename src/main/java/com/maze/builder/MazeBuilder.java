package com.maze.builder;

/**
 *
 * @author Dickson Kho Sep 12, 2015
 */
public interface MazeBuilder {

    char WALL = 'X';
    char SPACE = ' ';

    char[][] build();
    void printInfo();

}
