package com.flawlor.pathfinder.pathfinding.algorithms;

import com.flawlor.pathfinder.model.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearch implements Algorithm {
    private static final int[] ROW_VECTOR = {1, -1, 0, 0};
    private static final int[] COL_VECTOR = {0, 0, 1, -1};
    private boolean foundEnd = false;
    @Override
    public void findPath(char[][] grid, List<Coordinate> coveredSquares, List<Coordinate> pathSquares, Coordinate start,
                         Coordinate end) {
        Map<Coordinate, Coordinate> parents = new HashMap<>();
        BFS(grid, coveredSquares, start.getRow(), start.getCol(), parents);

        if (foundEnd) {
            Coordinate currParent = parents.get(end);

            while (parents.containsKey(currParent)) {
                pathSquares.add(0, currParent);
                currParent = parents.get(currParent);
            }
        }

        foundEnd = false;
    }

    private void BFS(char[][] grid, List<Coordinate> coveredSquares, int i, int j,
                              Map<Coordinate, Coordinate> parents) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        rows.add(i);
        cols.add(j);

        while (rows.size() > 0) {
            int row = rows.remove(0);
            int col = cols.remove(0);

            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 'P' || foundEnd) {
                continue;
            }

            if (grid[row][col] == 'E') {
                foundEnd = true;
                return;
            }

            if (grid[row][col] != 'S') {
                grid[row][col] = 'P';
                coveredSquares.add(new Coordinate(row, col));
            }


            for (int a = 0; a < ROW_VECTOR.length; a++) {
                rows.add(row + ROW_VECTOR[a]);
                cols.add(col + COL_VECTOR[a]);

                parents.put(new Coordinate(row + ROW_VECTOR[a], col + COL_VECTOR[a]), new Coordinate(row, col));
            }
        }
    }
}
