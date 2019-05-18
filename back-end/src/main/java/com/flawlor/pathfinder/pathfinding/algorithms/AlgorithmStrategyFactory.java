package com.flawlor.pathfinder.pathfinding.algorithms;

import com.flawlor.pathfinder.pathfinding.algorithms.strategies.BreadthFirstSearch;
import com.flawlor.pathfinder.pathfinding.algorithms.strategies.DepthFirstSearch;

public class AlgorithmStrategyFactory {
    public AlgorithmStrategy createAlgorithmStrategy(String algorithmStrategy) {
        AlgorithmStrategy strategy = null;

        if (algorithmStrategy != null) {
            if (Algorithm.DEPTH_FIRST_SEARCH.getCode().equalsIgnoreCase(algorithmStrategy)) {
                strategy = new DepthFirstSearch();
            } else if (Algorithm.BREADTH_FIRST_SEARCH.getCode().equalsIgnoreCase(algorithmStrategy)) {
                strategy = new BreadthFirstSearch();
            } else {
                System.err.println("Unknown algorithm strategy");
            }
        }

        return strategy;
    }
}
