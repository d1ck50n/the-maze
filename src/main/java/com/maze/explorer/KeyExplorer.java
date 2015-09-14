package com.maze.explorer;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dickson Kho Sep 12, 2015
 */
public class KeyExplorer {

    private final char[][] mazeGrid;
    private int maxGridX;
    private int maxGridY;
    private Point currentPoint;
    private final List<String> movementHistoryList = new ArrayList<>();

    public enum MOVE {

        LEFT, RIGHT, UP, DOWN
    }

    public KeyExplorer(char[][] grid, Point entryPoint) {
        this.mazeGrid = grid;
        this.maxGridX = grid.length;
        this.maxGridY = grid[0].length;
        this.currentPoint = entryPoint;
        movementHistoryList.add("You start at [" + entryPoint.x + "][" + entryPoint.y + "]");
    }

    public void setCurrentPoint(Point point) {
        this.currentPoint = point;
    }

    public Point getCurrentPoint() {
        return this.currentPoint;
    }

    public int getMaxGridX() {
        return maxGridX;
    }

    public void setMaxGridX(int maxGridX) {
        this.maxGridX = maxGridX;
    }

    public int getMaxGridY() {
        return maxGridY;
    }

    public void setMaxGridY(int maxGridY) {
        this.maxGridY = maxGridY;
    }

    public char[][] getMazeGrid() {
        return this.mazeGrid;
    }

    public void addMovementHistory(MOVE move, Point point) {
        movementHistoryList.add("Then you move: " + move + " to [" + point.x + "][" + point.y + "]");
    }

    public List getMovementHistoryList() {
        return this.movementHistoryList;
    }

}
