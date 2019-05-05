package com.flawlor.pathfinder.model;

import lombok.Data;

import java.util.List;

@Data
public class PathRequest {
    private Coordinate start;
    private Coordinate end;
    private List<Coordinate> obstacles;

    public PathRequest(Coordinate start, Coordinate end, List<Coordinate> obstacles) {
        this.start = start;
        this.end = end;
        this.obstacles = obstacles;
    }
}
