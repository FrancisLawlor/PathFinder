package com.flawlor.pathfinder.model;

import lombok.Data;

import java.util.List;

@Data
public class AlgorithmResponse {
    private List<String> algorithms;

    public AlgorithmResponse(List<String> algorithms) {
        this.algorithms = algorithms;
    }
}