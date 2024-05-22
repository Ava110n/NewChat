package org.example

import src.main.kotlin.Connection
import java.io.BufferedReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import kotlin.concurrent.thread

class Server(port: Int = 8080) {
    var br: BufferedReader? = null
    var pw: PrintWriter? = null
    var socket: ServerSocket = ServerSocket(port)

    //var clientSocket: Socket? = null
    lateinit var connectedClient: ConnectedClient
    lateinit var connection: Connection

    fun start() {
        var clientSocket = socket.accept()
        var newClientSocket = clientSocket
        connectedClient = newClientSocket?.let { ConnectedClient(it) }!!
        //connection = Connection(newClientSocket)
        thread {
            var stop = false
            while (!stop) {
                try {
                    var text = connectedClient.receive()
                    println(text)
                    connectedClient.sendAll(text.toString())
                } catch (e: Exception) {
                    connectedClient.remove_client(connectedClient)
                    println("oops")
                    stop = true
                }

            }
        }

    }

    /*fun send(text: String) = connection.send(text)/*{
        pw = PrintWriter(clientSocket?.getOutputStream(),true)
        pw!!.println()
    }*/
    fun receive(): String? = connection.receive()/*{
        br = clientSocket?.getInputStream()?.bufferedReader()
        return br?.readLine()
    }*/
    fun finish() = connection.finish()/*{
        br?.close()
        pw?.close()
    }*/
    fun stop() = connection.stopReceiving()/*{
        socket?.close()
        clientSocket?.close()
    }*/*/


}