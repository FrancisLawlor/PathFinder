package com.flawlor.pathfinder.assembler;

import com.flawlor.pathfinder.controller.PathRequestController;
import com.flawlor.pathfinder.model.PathRequest;
import com.flawlor.pathfinder.model.PathResponse;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PathResponseResourceAssembler implements ResourceAssembler<PathResponse, Resource<PathResponse>> {
    public Resource<PathResponse> toResource(PathRequest pathRequest, PathResponse pathResponse) {

        return new Resource<>(pathResponse,
                linkTo(methodOn(PathRequestController.class).calculatePath(pathRequest)).withSelfRel());
    }

    @Override
    public Resource<PathResponse> toResource(PathResponse entity) {
        return null;
    }
}
