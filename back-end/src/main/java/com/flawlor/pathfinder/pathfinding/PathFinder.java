package com.flawlor.pathfinder.pathfinding;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.pathfinding.algorithms.DepthFirstSearch;

import java.util.List;

public class PathFinder {
    public static void calculatePath(DepthFirstSearch algorithm, char[][] grid, List<Coordinate> coveredSquares, List<Coordinate> pathSquares,
    Coordinate start, Coordinate end) {
        DepthFirstSearch.findCoveredSquares(grid, coveredSquares, pathSquares, start, end);
    }
}
