package com.flawlor.pathfinder.service.impl;

import com.flawlor.pathfinder.model.AlgorithmResponse;
import com.flawlor.pathfinder.pathfinding.algorithms.AlgorithmType;
import com.flawlor.pathfinder.service.AlgorithmService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {

    @Override
    public AlgorithmResponse getAlgorithms() {
        List<String> algorithms = new ArrayList<>();

        for (AlgorithmType algorithm : AlgorithmType.values()) {
            algorithms.add(algorithm.getCode());
        }

        return new AlgorithmResponse(algorithms);
    }
}
