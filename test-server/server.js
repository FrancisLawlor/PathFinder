const SERVER_PORT = 8080;

let jsonServer = require('json-server')

let server = jsonServer.create()
let router = jsonServer.router(require('./routes.js')())
let defaultMiddlewares = jsonServer.defaults()
let customMiddlewares = require('./middlewares/post_request_middleware.js')

server.use(jsonServer.bodyParser)
server.use(defaultMiddlewares)
server.use(customMiddlewares)
server.use(router)
server.listen(SERVER_PORT, function () { 
    console.log('Mock Server is running on port ' + SERVER_PORT)
})