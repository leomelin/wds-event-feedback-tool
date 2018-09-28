~function () {
  const webSocket = new WebSocket('ws://localhost:8080/echo')
  const socketOpen = () => {
    webSocket.send("Hello from client")
    webSocket.send('{"uuid":"aa-bb-cc"}')

  }
  webSocket.onmessage = msg => console.log(msg)
  webSocket.onclose = () => console.log('WebSocket connection closed')
  webSocket.onopen = () => {
    socketOpen()
  }
}()