~function () {
  const startSurvey = {
    action: 'START_SURVEY',
    uuid: 'aa-bb-cc'
  }

  const webSocket = new WebSocket('ws://localhost:8080/socket')
  const socketOpen = () => {
    // webSocket.send("Hello from client")
    webSocket.send(JSON.stringify(startSurvey))

  }
  webSocket.onmessage = msg => console.log(msg)
  webSocket.onclose = () => console.log('WebSocket connection closed')
  webSocket.onopen = () => {
    socketOpen()
  }
}()