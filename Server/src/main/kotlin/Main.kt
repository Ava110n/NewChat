package org.example

import kotlin.concurrent.thread

fun main() {
    var stop = false
    val server = Server()
    while(!stop){
        //thread {
            server.start()
        //}

    }
}