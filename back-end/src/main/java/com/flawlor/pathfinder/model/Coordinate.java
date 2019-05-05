package com.flawlor.pathfinder.model;

import lombok.Data;

@Data
public class Coordinate {
    private int row;
    private int col;

    public Coordinate() {}

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
