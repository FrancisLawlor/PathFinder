package com.flawlor.pathfinder.pathfinding.algorithms;

public enum Algorithm {
    BREADTH_FIRST_SEARCH("Breadth First Search"),
    DEPTH_FIRST_SEARCH("Depth First Search");

    private final String code;

    Algorithm(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
