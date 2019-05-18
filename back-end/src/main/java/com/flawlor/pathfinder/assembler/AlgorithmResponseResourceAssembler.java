package com.flawlor.pathfinder.assembler;

import com.flawlor.pathfinder.controller.PathRequestController;
import com.flawlor.pathfinder.model.AlgorithmResponse;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class AlgorithmResponseResourceAssembler implements ResourceAssembler<AlgorithmResponse, Resource<AlgorithmResponse>> {
    public Resource<AlgorithmResponse> toResource(AlgorithmResponse algorithmResponse) {
        return new Resource<>(algorithmResponse,
                linkTo(methodOn(PathRequestController.class).getAlgorithms()).withSelfRel());
    }
}
