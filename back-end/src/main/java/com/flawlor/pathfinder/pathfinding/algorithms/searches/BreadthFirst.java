package com.flawlor.pathfinder.pathfinding.algorithms.searches;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.pathfinding.grid.GridPosition;

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

            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == GridPosition.OBSTACLE.getCode()
                    || foundEnd) {
                continue;
            }

            parents.put(new Coordinate(row, col), currentParents.get(0));
            currentParents.add(new Coordinate(row, col));

            if (grid[row][col] == GridPosition.END.getCode()) {
                foundEnd = true;
                return;
            }

            coveredSquares.add(new Coordinate(row, col));
            grid[row][col] = GridPosition.OBSTACLE.getCode();

            for (int i = 0; i < ROW_VECTOR.length; i++) {
                rows.add(row + ROW_VECTOR[i]);
                cols.add(col + COL_VECTOR[i]);
            }
        }
    }
}
