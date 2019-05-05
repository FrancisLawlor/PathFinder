package com.flawlor.pathfinder.controller;

import com.flawlor.pathfinder.assembler.PathResponseResourceAssembler;
import com.flawlor.pathfinder.model.Coordinate;
import com.flawlor.pathfinder.model.PathResponse;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Resource<PathResponse> calculatePath() {
        List<Coordinate> coveredSquares = new ArrayList<>();
        List<Coordinate> pathSquares = new ArrayList<>();

        coveredSquares.add(new Coordinate(0, 0));
        coveredSquares.add(new Coordinate(0, 1));
        coveredSquares.add(new Coordinate(0, 2));
        coveredSquares.add(new Coordinate(0, 3));

        pathSquares.add(new Coordinate(1, 0));
        pathSquares.add(new Coordinate(1, 1));
        pathSquares.add(new Coordinate(1, 2));
        pathSquares.add(new Coordinate(1, 3));

        PathResponse pathResponse = new PathResponse(coveredSquares, pathSquares);

        return this.assembler.toResource(pathResponse);

    }
}
