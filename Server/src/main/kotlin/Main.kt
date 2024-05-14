package org.example

fun main() {
    var stop = false
    val server = Server()
    while(!stop){
        server.start()
    }
}