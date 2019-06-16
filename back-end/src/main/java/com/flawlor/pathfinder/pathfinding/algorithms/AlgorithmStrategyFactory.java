package com.flawlor.pathfinder.pathfinding.algorithms;

import com.flawlor.pathfinder.pathfinding.algorithms.searches.BreadthFirst;
import com.flawlor.pathfinder.pathfinding.algorithms.searches.DepthFirst;

public class AlgorithmStrategyFactory {
    public Algorithm createAlgorithmStrategy(String algorithmName) {
        Algorithm algorithm = null;

        if (algorithmName != null) {
            if (AlgorithmType.DEPTH_FIRST_SEARCH.getCode().equalsIgnoreCase(algorithmName)) {
                algorithm = new DepthFirst();
            } else if (AlgorithmType.BREADTH_FIRST_SEARCH.getCode().equalsIgnoreCase(algorithmName)) {
                algorithm = new BreadthFirst();
            } else {
                System.err.println("Unknown algorithm");
            }
        }

        return algorithm;
    }
}