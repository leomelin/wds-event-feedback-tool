package dto.socketMessages

class StartSurveyRequest : SocketMessage(ActionType.START_SURVEY) {
   var uuid: String = ""
}