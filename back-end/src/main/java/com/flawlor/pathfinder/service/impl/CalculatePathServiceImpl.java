package com.flawlor.pathfinder.service.impl;

import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.model.PathRequest;
import com.flawlor.pathfinder.model.PathResponse;
import com.flawlor.pathfinder.pathfinding.algorithms.Algorithm;
import com.flawlor.pathfinder.pathfinding.algorithms.AlgorithmStrategyFactory;
import com.flawlor.pathfinder.pathfinding.grid.GridPosition;
import com.flawlor.pathfinder.service.CalculatePathService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatePathServiceImpl implements CalculatePathService {
    @Override
    public PathResponse calculatePath(PathRequest pathRequest) {
        List<Coordinate> coveredSquares = new ArrayList<>();
        List<Coordinate> pathSquares = new ArrayList<>();

        char[][] grid = createGrid(pathRequest);

        AlgorithmStrategyFactory algorithmStrategyFactory = new AlgorithmStrategyFactory();
        Algorithm algorithm = algorithmStrategyFactory.createAlgorithmStrategy(pathRequest.getAlgorithm());
        algorithm.findPath(grid, coveredSquares, pathSquares, pathRequest.getCoords().getStart(), pathRequest.getCoords().getEnd());

        return new PathResponse(coveredSquares, pathSquares);
    }

    private char[][] createGrid(PathRequest pathRequest) {
        char[][] grid = new char[pathRequest.getHeight()][pathRequest.getWidth()];
        grid[pathRequest.getCoords().getStart().getRow()][pathRequest.getCoords().getStart().getCol()] = GridPosition.START.getCode();
        grid[pathRequest.getCoords().getEnd().getRow()][pathRequest.getCoords().getEnd().getCol()] = GridPosition.END.getCode();

        for (Coordinate obstacle : pathRequest.getCoords().getObstacles()) {
            grid[obstacle.getRow()][obstacle.getCol()] = GridPosition.OBSTACLE.getCode();
        }

        return grid;
    }
}
