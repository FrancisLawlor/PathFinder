package com.flawlor.pathfinder.pathfinding;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.pathfinding.algorithms.AlgorithmStrategy;

import java.util.List;

public class PathFinder {
    public static void calculatePath(AlgorithmStrategy algorithm, char[][] grid, List<Coordinate> coveredSquares, List<Coordinate> pathSquares,
                                     Coordinate start, Coordinate end) {
        algorithm.findPath(grid, coveredSquares, pathSquares, start, end);
    }
}
