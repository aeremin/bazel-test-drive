package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// Ways to run:
// - Normal run: `bazel run //:server`
// - Running the docker image: `bazel run //:server_docker` (for some reason exposing port not working with this?)
// - Building docker image (bazel build //:server_docker) and running it separately (docker run -p 8081:8081 bazel:server_docker).
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