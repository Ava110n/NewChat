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

    fun remove_client(connectedClient: ConnectedClient){
        println(clients.size)
        clients.remove(connectedClient)
        println(clients.size)
    }

    fun sendAll(text: String)= clients.onEach {
        it.send(text)
    }

    fun send(text: String) = connection.send(text)

    fun receive()= connection.receive()

}