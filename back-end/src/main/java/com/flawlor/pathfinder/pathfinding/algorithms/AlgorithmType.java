package com.flawlor.pathfinder.pathfinding.algorithms;

public enum AlgorithmType {
    BREADTH_FIRST_SEARCH("Breadth First Search"),
    DEPTH_FIRST_SEARCH("Depth First Search");

    private final String code;

    AlgorithmType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
