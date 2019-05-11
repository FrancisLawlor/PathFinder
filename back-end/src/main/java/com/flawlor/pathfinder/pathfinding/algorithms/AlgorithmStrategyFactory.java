package com.flawlor.pathfinder.pathfinding.algorithms;

import com.flawlor.pathfinder.pathfinding.algorithms.strategies.BreadthFirstSearch;
import com.flawlor.pathfinder.pathfinding.algorithms.strategies.DepthFirstSearch;

public class AlgorithmStrategyFactory {
    private static final String DEPTH_FIRST_SEARCH = "depth_first_search";
    private static final String BREADTH_FIRST_SEARCH = "breadth_first_search";

    public AlgorithmStrategy createAlgorithmStrategy(String algorithmStrategy) {
        AlgorithmStrategy strategy = null;

        if (algorithmStrategy != null) {
            if (DEPTH_FIRST_SEARCH.equalsIgnoreCase(algorithmStrategy)) {
                strategy = new DepthFirstSearch();
            } else if (BREADTH_FIRST_SEARCH.equalsIgnoreCase(algorithmStrategy)) {
                strategy = new BreadthFirstSearch();
            } else {
                System.err.println("Unknown algorithm strategy");
            }
        }

        return strategy;
    }
}
