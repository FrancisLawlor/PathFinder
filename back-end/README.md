# Path Finder Back-end

Back-end Spring Boot application.

Deployed on [heroku](http://francislawlor-pathfinder-be.herokuapp.com/).

### Run 

```./gradlew bootRun```

or use Docker

```
docker build -t back-end .
docker run -p 8080:8080 back-end
```

### End points

GET ```/algorithms```

Provides list of implemented search algorithms to the front-end, which users can then choose from.

Example Response:

```
{
    "algorithms": [
        "Breadth First Search",
        "Depth First Search"
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/algorithms"
        }
    ]
}
```

POST ```/calculate_path```

Accepts payload containing information relating to the dimensions of the grid and the coordinates of the start point, end point and obstacles.

Response contains coordinates followed by the path between start and end point.

Example Request:

```
{
    "height": 6,
    "width": 6,
    "coords": {
        "start": {
            "row": 1,
            "col": 0
        },
        "end": {
            "row": 3,
            "col": 4
        },
        "obstacles": [
            {
                "row": 1,
                "col": 3
            },
            {
                "row": 2,
                "col": 2
            },
            {
                "row": 3,
                "col": 2
            }
        ]
    },
    "algorithm": "Breadth First Search"
}
```

Example Response:

```
{
    "covered_squares": [
        {
            "row": 2,
            "col": 0
        },
        {
            "row": 0,
            "col": 0
        },
        {
            "row": 1,
            "col": 1
        },
        {
            "row": 3,
            "col": 0
        },
        {
            "row": 2,
            "col": 1
        },
        {
            "row": 0,
            "col": 1
        },
        {
            "row": 1,
            "col": 2
        },
        {
            "row": 4,
            "col": 0
        },
        {
            "row": 3,
            "col": 1
        },
        {
            "row": 0,
            "col": 2
        },
        {
            "row": 5,
            "col": 0
        },
        {
            "row": 4,
            "col": 1
        },
        {
            "row": 0,
            "col": 3
        },
        {
            "row": 5,
            "col": 1
        },
        {
            "row": 4,
            "col": 2
        },
        {
            "row": 0,
            "col": 4
        },
        {
            "row": 5,
            "col": 2
        },
        {
            "row": 4,
            "col": 3
        },
        {
            "row": 1,
            "col": 4
        },
        {
            "row": 0,
            "col": 5
        },
        {
            "row": 5,
            "col": 3
        },
        {
            "row": 3,
            "col": 3
        },
        {
            "row": 4,
            "col": 4
        },
        {
            "row": 2,
            "col": 4
        },
        {
            "row": 1,
            "col": 5
        },
        {
            "row": 5,
            "col": 4
        },
        {
            "row": 2,
            "col": 3
        }
    ],
    "path_squares": [
        {
            "row": 2,
            "col": 0
        },
        {
            "row": 3,
            "col": 0
        },
        {
            "row": 4,
            "col": 0
        },
        {
            "row": 4,
            "col": 1
        },
        {
            "row": 4,
            "col": 2
        },
        {
            "row": 4,
            "col": 3
        },
        {
            "row": 3,
            "col": 3
        }
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/calculate_path"
        }
    ]
}
```
