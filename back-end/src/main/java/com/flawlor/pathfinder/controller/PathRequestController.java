package com.flawlor.pathfinder.controller;

import com.flawlor.pathfinder.assembler.AlgorithmResponseResourceAssembler;
import com.flawlor.pathfinder.assembler.PathResponseResourceAssembler;
import com.flawlor.pathfinder.model.AlgorithmResponse;
import com.flawlor.pathfinder.model.PathRequest;
import com.flawlor.pathfinder.model.PathResponse;
import com.flawlor.pathfinder.service.AlgorithmService;
import com.flawlor.pathfinder.service.CalculatePathService;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PathRequestController {
    private final AlgorithmService algorithmService;
    private final CalculatePathService calculatePathService;

    private final PathResponseResourceAssembler pathResponseResourceAssembler;
    private final AlgorithmResponseResourceAssembler algorithmResourceAssembler;

    public PathRequestController(PathResponseResourceAssembler pathResponseResourceAssembler,
                                 AlgorithmResponseResourceAssembler algorithmResourceAssembler,
                                 AlgorithmService algorithmService,
                                 CalculatePathService calculatePathService) {
        this.pathResponseResourceAssembler = pathResponseResourceAssembler;
        this.algorithmResourceAssembler = algorithmResourceAssembler;
        this.algorithmService = algorithmService;
        this.calculatePathService = calculatePathService;
    }

    @CrossOrigin
    @PostMapping(path = "/calculate_path", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Resource<PathResponse> calculatePath(@Valid @RequestBody PathRequest pathRequest) {
        PathResponse pathResponse = calculatePathService.calculatePath(pathRequest);

        return this.pathResponseResourceAssembler.toResource(pathRequest, pathResponse);
    }

    @CrossOrigin
    @GetMapping(path = "/algorithms", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Resource<AlgorithmResponse> getAlgorithms() {
        return this.algorithmResourceAssembler.toResource(algorithmService.getAlgorithms());
    }
}
