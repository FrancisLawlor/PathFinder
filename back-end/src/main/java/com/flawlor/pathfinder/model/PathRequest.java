package com.flawlor.pathfinder.model;

import lombok.Data;

@Data
public class PathRequest {
    private int height;
    private int width;
    private CoordinateInfo coords;
    private String algorithm;

    public PathRequest() {}

    public PathRequest(int height, int width, CoordinateInfo coords, String algorithmName) {
        this.height = height;
        this.width = width;
        this.coords = coords;
        this.algorithm = algorithmName;
    }
}
