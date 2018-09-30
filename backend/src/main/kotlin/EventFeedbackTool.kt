
import socket.SurveyWebSocket
import spark.Spark.init
import spark.Spark.webSocket
import spark.kotlin.Http
import spark.kotlin.ignite

fun main(args: Array<String>) {
    val socketPort = 8080
    val restPort = 8081
    println("Server Web Socket running on port $socketPort")
    println("Server REST endpoints running on port $restPort")
    spark.kotlin.port(socketPort)

    webSocket("/socket", SurveyWebSocket::class.java)
    init()
    val http: Http = ignite()
    http.port(restPort)
    http.get("/hello") {
        "Hello Spark Kotlin!"
    }
}