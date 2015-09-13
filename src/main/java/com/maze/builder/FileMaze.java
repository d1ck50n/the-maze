package com.maze.builder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dickson Kho Sep 12, 2015
 */
public class FileMaze implements MazeBuilder {

    private int totalWall = 0;
    private int totalSpace = 0;

    @Override
    public char[][] build() {

        ClassLoader classLoader = getClass().getClassLoader();
        File mazeTemplate = new File(classLoader.getResource("maze.txt").getFile());

        try (LineNumberReader reader = new LineNumberReader(new FileReader(mazeTemplate))) {
            List<String> totalLines = new ArrayList<>();

            // read file once and save content into collection
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                totalLines.add(line);
            }

            if (!totalLines.isEmpty()) {
                // initialize char array
                int maxGridX = totalLines.get(0).length();
                int maxGridY = reader.getLineNumber();
                char[][] grid = new char[maxGridX][maxGridY];

                for (int y = 0; y < maxGridY; y++) {
                    char[] lineArr = totalLines.get(maxGridY - (y + 1)).toCharArray();
                    for (int x = 0; x < maxGridX; x++) {
                        grid[x][y] = lineArr[x];
                        if (lineArr[x] == MazeBuilder.SPACE) {
                            this.totalSpace++;
                        }
                        if (lineArr[x] == MazeBuilder.WALL) {
                            this.totalWall++;
                        }
                    }
                }
                return grid;
            }

        } catch (IOException ex) {
            System.out.println("Fail to build maze from file due to: " + ex);
        }

        return new char[0][0];
    }

    @Override
    public void printInfo() {
        System.out.println("\nNumber of wall = " + this.totalWall);
        System.out.println("Number of empty space = " + this.totalSpace + "\n");
    }

}
