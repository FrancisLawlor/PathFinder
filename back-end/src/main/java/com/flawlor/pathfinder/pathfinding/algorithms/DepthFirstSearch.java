package com.flawlor.pathfinder.pathfinding.algorithms;

import com.flawlor.pathfinder.model.Coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch implements Algorithm {
    private boolean foundEnd = false;

    @Override
    public void findPath(char[][] grid, List<Coordinate> coveredSquares, List<Coordinate> pathSquares,
                                Coordinate start, Coordinate end) {
        Map<Coordinate, Coordinate> parents = new HashMap<>();
        recursiveDFS(grid, coveredSquares, start.getRow(), start.getCol(), -1, -1, parents);

        if (foundEnd) {
            Coordinate currParent = parents.get(end);

            while (parents.containsKey(currParent)) {
                pathSquares.add(0, currParent);
                currParent = parents.get(currParent);
            }
        }

        foundEnd = false;
    }

    private void recursiveDFS(char[][] grid, List<Coordinate> coveredSquares, int i, int j, int prevI, int prevJ,
                                     Map<Coordinate, Coordinate> parents) {
        if (i < 0 || i >= grid.length || j < 0 || i >= grid[0].length || grid[i][j] == 'P' || foundEnd) {
            return;
        }

        if (grid[i][j] == 'E') {
            parents.put(new Coordinate(i, j), new Coordinate(prevI, prevJ));
            foundEnd = true;
            return;
        }

        if (grid[i][j] != 'S') {
            grid[i][j] = 'P';
            coveredSquares.add(new Coordinate(i, j));
            parents.put(new Coordinate(i, j), new Coordinate(prevI, prevJ));
        }

        recursiveDFS(grid, coveredSquares, i + 1, j, i, j, parents);
        recursiveDFS(grid, coveredSquares, i - 1, j, i, j, parents);
        recursiveDFS(grid, coveredSquares, i, j + 1, i, j, parents);
        recursiveDFS(grid, coveredSquares, i, j - 1, i, j, parents);
    }
}
