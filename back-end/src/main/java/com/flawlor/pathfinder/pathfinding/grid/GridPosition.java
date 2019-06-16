package com.flawlor.pathfinder.pathfinding.grid;

public enum GridPosition {
    START('S'),
    END('E'),
    OBSTACLE('X');

    private final char code;

    GridPosition(char code) {
        this.code = code;
    }

    public char getCode() {
        return this.code;
    }
}
