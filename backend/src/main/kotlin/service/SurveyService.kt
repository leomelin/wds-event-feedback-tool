package service

import spark.kotlin.RouteHandler

fun handleGetHello(routeHandler: RouteHandler): String {
    return "Hello!"
}
