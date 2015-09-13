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
    private final List<String> movementStore = new ArrayList<>();

    public enum MOVE {

        LEFT, RIGHT, UP, DOWN
    }

    public KeyExplorer(char[][] grid, Point entryPoint) {
        this.mazeGrid = grid;
        this.maxGridX = grid.length;
        this.maxGridY = grid[0].length;
        this.currentPoint = entryPoint;
        movementStore.add("You start at [" + entryPoint.x + "][" + entryPoint.y + "]");
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

    public void printCurrentPoint() {
        System.out.println("Current coordinate: " + currentPoint.x + ", " + currentPoint.y);
    }

    public void addMovement(MOVE move, Point point) {
        movementStore.add("Then you move: " + move + " to [" + point.x + "][" + point.y + "]");
    }

    public List getMovementStore(){
        return this.movementStore;
    }
}
