package com.flawlor.pathfinder.pathfinding.algorithms;

import com.flawlor.pathfinder.model.Coordinate;

import java.util.List;

public interface Algorithm {
    void findPath(char[][] grid, List<Coordinate> coveredSquares, List<Coordinate> pathSquares,
                  Coordinate start, Coordinate end);
}
