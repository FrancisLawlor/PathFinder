package com.flawlor.pathfinder.service;

import com.flawlor.pathfinder.model.PathRequest;
import com.flawlor.pathfinder.model.PathResponse;

public interface CalculatePathService {
    PathResponse calculatePath(PathRequest pathRequest);
}
