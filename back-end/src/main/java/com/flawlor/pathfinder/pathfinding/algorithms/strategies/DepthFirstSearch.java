package com.flawlor.pathfinder.pathfinding.algorithms.strategies;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.pathfinding.algorithms.AlgorithmStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch implements AlgorithmStrategy {
    private static final int[] ROW_VECTOR = {1, -1, 0, 0};
    private static final int[] COL_VECTOR = {0, 0, 1, -1};
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
        if (i < 0 || i >= grid.length || j < 0 || i >= grid[0].length || grid[i][j] == 'P' || grid[i][j] == 'X' || foundEnd) {
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

        for (int a = 0; a < ROW_VECTOR.length; a++) {
            recursiveDFS(grid, coveredSquares, i + ROW_VECTOR[a], j + COL_VECTOR[a], i, j, parents);
        }
    }
}
