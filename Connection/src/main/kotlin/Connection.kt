package src.main.kotlin

import java.io.BufferedReader
import java.io.PrintWriter
import java.net.Socket
import kotlin.concurrent.thread

class Connection {
    private var socket: Socket? = null
    private var br: BufferedReader? = null
    private var pw: PrintWriter? = null

    private var stop = false

    constructor(socket: Socket){
        this.socket = socket
    }

    fun start(){
        thread {
            try{
                while(!stop){
                    receive()
                }
            }
            catch (e:Exception){

            }
        }
    }

    fun send(text: String) {
        pw = socket?.getOutputStream()?.let { PrintWriter(it, true) }
        pw?.println(text)
    }

    fun receive():String? {
        stop = false
        br = socket?.getInputStream()?.bufferedReader()
        //while (!stop) {
        return br?.readLine()
       // }

    }

    fun finish() {
        br?.close()
        pw?.close()

    }

    fun stopReceiving() {
        stop = true
        socket?.close()
    }

}