Data for mock server created using [JSON Server](https://github.com/typicode/json-server).

`/middlewares` contains logic for modifying requests.

`/data` contains example response data.

Command for starting the server with middleware and data:

`json-server --middlewares middlewares/post_request_middleware.js --watch data/calculated_path_response.json --port 3004`
