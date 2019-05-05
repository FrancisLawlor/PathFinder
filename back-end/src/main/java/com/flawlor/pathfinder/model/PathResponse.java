package com.flawlor.pathfinder.model;

import lombok.Data;

import java.util.List;

@Data
public class PathResponse {
    private List<Coordinate> coveredSquares;
    private List<Coordinate> pathSquares;

    public PathResponse(List<Coordinate> coveredSquares, List<Coordinate> pathSquares) {
        this.coveredSquares = coveredSquares;
        this.pathSquares = pathSquares;
    }
}
