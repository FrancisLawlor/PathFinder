package com.flawlor.pathfinder.controller;

import com.flawlor.pathfinder.assembler.PathResponseResourceAssembler;
import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.model.PathRequest;
import com.flawlor.pathfinder.model.PathResponse;
import com.flawlor.pathfinder.pathfinding.algorithms.Algorithm;
import com.flawlor.pathfinder.pathfinding.algorithms.BreadthFirstSearch;
import com.flawlor.pathfinder.pathfinding.algorithms.DepthFirstSearch;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.flawlor.pathfinder.pathfinding.PathFinder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PathRequestController {
    private final PathResponseResourceAssembler assembler;

    public PathRequestController(PathResponseResourceAssembler assembler) {
        this.assembler = assembler;
    }

    @CrossOrigin
    @PostMapping(path = "/calculate_path", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Resource<PathResponse> calculatePath(@Valid @RequestBody PathRequest pathRequest) {
        List<Coordinate> coveredSquares = new ArrayList<>();
        List<Coordinate> pathSquares = new ArrayList<>();

        char[][] grid = new char[pathRequest.getHeight()][pathRequest.getWidth()];
        grid[pathRequest.getCoords().getStart().getRow()][pathRequest.getCoords().getStart().getCol()] = 'S';
        grid[pathRequest.getCoords().getEnd().getRow()][pathRequest.getCoords().getEnd().getCol()] = 'E';

        for (Coordinate obstacle: pathRequest.getCoords().getObstacles()) {
            grid[obstacle.getRow()][obstacle.getCol()] = 'X';
        }

        Algorithm algorithm = new BreadthFirstSearch();

        PathFinder.calculatePath(algorithm, grid, coveredSquares, pathSquares, pathRequest.getCoords().getStart(),
                pathRequest.getCoords().getEnd());

        PathResponse pathResponse = new PathResponse(coveredSquares, pathSquares);

        return this.assembler.toResource(pathRequest, pathResponse);

    }
}
