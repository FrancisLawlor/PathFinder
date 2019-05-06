package com.flawlor.pathfinder.model;

import lombok.Data;

import java.util.List;

@Data
public class PathResponse {
    private List<Coordinate> covered_squares;
    private List<Coordinate> path_squares;

    public PathResponse(List<Coordinate> coveredSquares, List<Coordinate> pathSquares) {
        this.covered_squares = coveredSquares;
        this.path_squares = pathSquares;
    }
}
