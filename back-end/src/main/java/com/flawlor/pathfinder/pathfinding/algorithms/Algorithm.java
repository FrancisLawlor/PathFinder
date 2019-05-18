package com.flawlor.pathfinder.pathfinding.algorithms;

public enum Algorithm {
    BREADTH_FIRST_SEARCH("breadth_first_search"),
    DEPTH_FIRST_SEARCH("depth_first_search");

    private final String code;

    Algorithm(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
