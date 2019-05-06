package com.flawlor.pathfinder.pathfinding;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.pathfinding.algorithms.DepthFirstSearch;

import java.util.List;

public class PathFinder {
    public static void calculatePath(DepthFirstSearch algorithm, char[][] grid, List<Coordinate> coveredSquares, List<Coordinate> pathSquares,
    Coordinate start) {
        DepthFirstSearch.findCoveredSquares(grid, coveredSquares, start);

        pathSquares.add(new Coordinate(1, 0));
        pathSquares.add(new Coordinate(1, 1));
        pathSquares.add(new Coordinate(1, 2));
        pathSquares.add(new Coordinate(1, 3));
    }
}
