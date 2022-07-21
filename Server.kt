package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// Ways to run:
// - Normal run: `bazel run //:server`
// - Running the docker image: `sudo bazel run //:server_docker`
//   TODO: Figure out how to run it without sudo
//   TODO(https://github.com/bazelbuild/rules_docker/issues/1958): Make runnable under Windows (without WSL)
fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0") {
        println("Hello world")
        routing {
            get("/") {
                call.respondText("Hello World!")
            }
        }
    }.start(wait = true)
}