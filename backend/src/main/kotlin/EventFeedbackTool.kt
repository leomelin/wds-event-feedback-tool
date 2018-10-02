import controller.SurveyController
import info.macias.kaconf.ConfiguratorBuilder
import info.macias.kaconf.Property
import info.macias.kaconf.sources.JavaUtilPropertySource
import socket.SurveyWebSocket
import spark.Spark
import spark.kotlin.Http
import spark.kotlin.ignite

class EventFeedbackTool {
    @Property("websocket.port")
    var socketPort: Int = 0

    @Property("rest.port")
    var restPort: Int = 0

    fun initialize() {
        println("Server Web Socket running on port $socketPort")
        println("Server REST endpoints running on port $restPort")
        spark.kotlin.port(socketPort)

        Spark.webSocket("/socket", SurveyWebSocket::class.java)
        Spark.init()
        val http: Http = ignite()
        http.port(restPort)
        SurveyController(http)
    }
}

fun main(args: Array<String>) {
    // Apply configuration
    val app = EventFeedbackTool()
    val property =
        JavaUtilPropertySource.from(app::class.java.classLoader.getResource("application.properties").file)
    val conf = ConfiguratorBuilder()
        .addSource(
            property
        ).build()
    conf.configure(app)

    app.initialize()
}
