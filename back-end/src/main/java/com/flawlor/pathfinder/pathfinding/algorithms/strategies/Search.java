package com.flawlor.pathfinder.pathfinding.algorithms.strategies;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.pathfinding.algorithms.Algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Search implements Algorithm {
    static final int[] ROW_VECTOR = {1, -1, 0, 0};
    static final int[] COL_VECTOR = {0, 0, 1, -1};
    boolean foundEnd = false;

    @Override
    public void findPath(char[][] grid, List<Coordinate> coveredSquares, List<Coordinate> pathSquares, Coordinate start,
                         Coordinate end) {
        Map<Coordinate, Coordinate> parents = new HashMap<>();
        search(grid, coveredSquares, start, end, parents);

        if (foundEnd) {
            Coordinate currParent = parents.get(end);

            while (parents.containsKey(currParent)) {
                pathSquares.add(0, currParent);
                currParent = parents.get(currParent);
            }
        }

        foundEnd = false;
    }

    abstract void search(char[][] grid, List<Coordinate> coveredSquares, Coordinate start, Coordinate end,
                         Map<Coordinate, Coordinate> parents);
}
