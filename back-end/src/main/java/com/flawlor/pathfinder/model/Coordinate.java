package com.flawlor.pathfinder.model;

import lombok.Data;

import java.util.Objects;

@Data
public class Coordinate {
    private int row;
    private int col;

    public Coordinate() {}

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        return (o instanceof Coordinate) && ((Coordinate) o).getRow() == this.getRow() &&
                ((Coordinate) o).getCol() == this.getCol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
