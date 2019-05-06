package com.flawlor.pathfinder.pathfinding.algorithms;

import com.flawlor.pathfinder.model.Coordinate;

import java.util.List;

public class DepthFirstSearch {
    private static boolean foundEnd = false;

    public static void findCoveredSquares(char[][] grid, List<Coordinate> coveredSquares, Coordinate start) {
        recursiveDFS(grid, coveredSquares, start.getRow(), start.getCol());
        foundEnd = false;
    }

    private static void recursiveDFS(char[][] grid, List<Coordinate> coveredSquares, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || i >= grid[0].length || grid[i][j] == 'P' || foundEnd) {
            return;
        }

        if (grid[i][j] == 'E') {
            foundEnd = true;
            return;
        }

        if (grid[i][j] != 'S') {
            grid[i][j] = 'P';
            coveredSquares.add(new Coordinate(i, j));
        }

        recursiveDFS(grid, coveredSquares, i + 1, j);
        recursiveDFS(grid, coveredSquares, i - 1, j);
        recursiveDFS(grid, coveredSquares, i, j + 1);
        recursiveDFS(grid, coveredSquares, i, j - 1);
    }
}
