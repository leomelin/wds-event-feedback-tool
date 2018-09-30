package dto.socketMessages

class LockSurveyRequest : SocketMessage(ActionType.LOCK_SURVEY) {
   var uuid: String = ""
}