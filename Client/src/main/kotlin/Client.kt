import src.main.kotlin.Connection
import java.net.Socket

class Client( val host: String = "localhost", val port: Int = 8080) {
    var socket: Socket? = null
    var connection: Connection = Connection(Socket(host, port))

    fun send(text: String) = connection.send(text)

}