package com.flawlor.pathfinder.model;

import lombok.Data;

import java.util.List;

@Data
public class CoordinateInfo {
    private Coordinate start;
    private Coordinate end;
    private List<Coordinate> obstacles;

    public CoordinateInfo() {}

    public CoordinateInfo(Coordinate start, Coordinate end, List<Coordinate> obstacles) {
        this.start = start;
        this.end = end;
        this.obstacles = obstacles;
    }
}
