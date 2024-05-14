package org.example

import java.io.BufferedReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server(port: Int = 8080) {
    var br : BufferedReader? = null
    var pw :PrintWriter? = null
    var socket: ServerSocket = ServerSocket(port)
    var clientSocket: Socket? = null
    fun start(){
        clientSocket = socket.accept()
    }
    fun send(text: String){
        pw = PrintWriter(clientSocket?.getOutputStream(),true)
        pw!!.println()
    }
    fun receive():String?{
        br = clientSocket?.getInputStream()?.bufferedReader()
        return br?.readLine()
    }
    fun finish(){
        br?.close()
        pw?.close()
    }
    fun stop(){
        socket?.close()
        clientSocket?.close()
    }


}