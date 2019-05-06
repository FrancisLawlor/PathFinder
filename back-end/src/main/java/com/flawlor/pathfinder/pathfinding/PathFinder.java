package com.flawlor.pathfinder.pathfinding;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.pathfinding.algorithms.Algorithm;

import java.util.List;

public class PathFinder {
    public static void calculatePath(Algorithm algorithm, char[][] grid, List<Coordinate> coveredSquares, List<Coordinate> pathSquares,
                                     Coordinate start, Coordinate end) {
        algorithm.findPath(grid, coveredSquares, pathSquares, start, end);
    }
}
