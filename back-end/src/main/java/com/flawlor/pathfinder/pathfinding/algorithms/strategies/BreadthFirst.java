package com.flawlor.pathfinder.pathfinding.algorithms.strategies;

import com.flawlor.pathfinder.model.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BreadthFirst extends Search {
    @Override
    void search(char[][] grid, List<Coordinate> coveredSquares, Coordinate start, Coordinate end, Map<Coordinate, Coordinate> parents) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        rows.add(start.getRow());
        cols.add(start.getCol());

        List<Coordinate> currentParents = new ArrayList<>();
        currentParents.add(null);
        int remainingChildrenForCurrentParent = 1;

        while (rows.size() > 0) {
            int row = rows.remove(0);
            int col = cols.remove(0);

            if (remainingChildrenForCurrentParent == 4) {
                currentParents.remove(0);
            }

            remainingChildrenForCurrentParent--;

            if (remainingChildrenForCurrentParent == 0) {
                remainingChildrenForCurrentParent = 4;
            }

            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 'P' ||
                    grid[row][col] == 'X' || foundEnd) {
                continue;
            }

            parents.put(new Coordinate(row, col), currentParents.get(0));
            currentParents.add(new Coordinate(row, col));

            if (grid[row][col] == 'E') {
                foundEnd = true;
                return;
            }

            if (grid[row][col] != 'S') {
                coveredSquares.add(new Coordinate(row, col));
            }

            grid[row][col] = 'P';

            for (int a = 0; a < ROW_VECTOR.length; a++) {
                rows.add(row + ROW_VECTOR[a]);
                cols.add(col + COL_VECTOR[a]);
            }
        }
    }
}
