import src.main.kotlin.Connection
import java.net.Socket

class Client( val host: String = "localhost", val port: Int = 8080) {
    var socket: Socket? = null
    var connection: Connection? = null

    fun start(){
        try {
            socket = Socket(host, port)
            connection =  Connection(socket!!)
        }catch (e: Exception){
            println("client disconnected")
        }

    }

    fun send(text: String) = connection?.send(text)
    fun receive()=connection?.receive()

}