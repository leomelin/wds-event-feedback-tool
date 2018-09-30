package dto.socketMessages

class JoinSurveyRequest : SocketMessage(ActionType.JOIN_SURVEY) {
   var uuid: String = ""
}