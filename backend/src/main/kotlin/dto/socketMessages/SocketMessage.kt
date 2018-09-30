package dto.socketMessages

open class SocketMessage {
    var action: ActionType = ActionType.NO_OP
    constructor(action: ActionType) {
        this.action = action
    }
}