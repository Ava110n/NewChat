package org.example
import src.main.kotlin.Connection
import java.net.Socket

class ConnectedClient(socket: Socket) {
    companion object{
        val clients = mutableListOf<ConnectedClient>()
    }
    private var connection = Connection(socket)

    init{
        clients.add(this)
    }

    fun sendAll(text: String)= clients.onEach {
        it.send(text)
    }

    fun send(text: String) = connection.send(text)

}