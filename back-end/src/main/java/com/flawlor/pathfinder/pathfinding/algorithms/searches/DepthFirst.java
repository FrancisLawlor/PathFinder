package com.flawlor.pathfinder.pathfinding.algorithms.searches;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.pathfinding.grid.GridPosition;

import java.util.List;
import java.util.Map;

public class DepthFirst extends Search {
    @Override
    void search(char[][] grid, List<Coordinate> coveredSquares, Coordinate start, Coordinate end, Map<Coordinate, Coordinate> parents) {
        recursiveDFS(grid, coveredSquares, start.getRow(), start.getCol(), -1, -1, parents);
    }

    private void recursiveDFS(char[][] grid, List<Coordinate> coveredSquares, int i, int j, int prevI, int prevJ,
                              Map<Coordinate, Coordinate> parents) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == GridPosition.OBSTACLE.getCode()
                || foundEnd) {
            return;
        }

        if (grid[i][j] == GridPosition.END.getCode()) {
            parents.put(new Coordinate(i, j), new Coordinate(prevI, prevJ));
            foundEnd = true;
            return;
        }

        grid[i][j] = GridPosition.OBSTACLE.getCode();
        coveredSquares.add(new Coordinate(i, j));
        parents.put(new Coordinate(i, j), new Coordinate(prevI, prevJ));

        for (int a = 0; a < ROW_VECTOR.length; a++) {
            recursiveDFS(grid, coveredSquares, i + ROW_VECTOR[a], j + COL_VECTOR[a], i, j, parents);
        }
    }
}
