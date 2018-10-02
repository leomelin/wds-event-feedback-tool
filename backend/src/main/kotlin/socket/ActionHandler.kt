package socket

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import dto.socketMessages.ActionType
import dto.socketMessages.JoinSurveyRequest
import dto.socketMessages.LockSurveyRequest
import dto.socketMessages.StartSurveyRequest
import exception.HandleActionException
import org.eclipse.jetty.websocket.api.Session

class ActionHandler(private val session: Session) {
    private val mapper = ObjectMapper()
    fun handle(message: String) {
        val actionType =
            ActionType.valueOf(ObjectMapper().readValue(message, ObjectNode::class.java).get("action").textValue())

        when (actionType) {
            ActionType.START_SURVEY -> handleStartSurvey(mapper.readValue(message, StartSurveyRequest::class.java))
            ActionType.LOCK_SURVEY -> handleLockSurvey(mapper.readValue(message, LockSurveyRequest::class.java))
            ActionType.JOIN_SURVEY -> handleJoinSurvey(mapper.readValue(message, JoinSurveyRequest::class.java))
            else -> {
                throw HandleActionException("Action type not found")
            }
        }
    }

    private fun handleJoinSurvey(req: JoinSurveyRequest) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun handleLockSurvey(req: LockSurveyRequest) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun handleStartSurvey(req: StartSurveyRequest) {
        send(object { val kissa = "22" })
    }

    private fun send(obj: Any) {
        session.remote.sendString(mapper.writeValueAsString(obj))
    }
}