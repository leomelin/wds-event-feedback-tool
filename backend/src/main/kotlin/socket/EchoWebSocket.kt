package socket


import com.fasterxml.jackson.databind.ObjectMapper
import dto.JoinSurveyRequest
import org.eclipse.jetty.websocket.api.Session
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage
import org.eclipse.jetty.websocket.api.annotations.WebSocket
import java.io.IOException
import java.util.concurrent.ConcurrentLinkedQueue

@WebSocket
class EchoWebSocket {

    @OnWebSocketConnect
    fun connected(session: Session) {
        sessions.add(session)
    }

    @OnWebSocketClose
    fun closed(session: Session, statusCode: Int, reason: String) {
        sessions.remove(session)
    }

    @OnWebSocketMessage
    @Throws(IOException::class)
    fun message(session: Session, message: String) {
        println("Got: $message")   // Print message
        val readValue: JoinSurveyRequest
        try {
           readValue = ObjectMapper().readValue(message, JoinSurveyRequest::class.java)
        } catch (e: Exception) {
            println("cannot read to json")
        }
        session.remote.sendString(message) // and send it back
    }

    companion object {
        // Store sessions if you want to, for example, broadcast a message to all users
        private val sessions = ConcurrentLinkedQueue<Session>()
    }

}