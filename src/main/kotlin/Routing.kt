package com.exercise

import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {

        // Exercise 1
        get("/") {
            call.respondText("Server is online at Lehman College.")
        }

        // Exercise 2
        get("/greet/{name}") {

            val name = call.parameters["name"]

            call.respondText("Hello, $name! Welcome to CMP 269.")
        }

        // Exercise 3
        val grades =mapOf(
            "123" to 95,
            "456" to 82
        )

        get("/grade/{studentId}") {
            val studentId =  call.parameters["studentId"]

            val grade = grades[studentId]

            if (grade != null) {
                call.respondText("Grade: $grade")
            } else {
                call.respondText(
                    "Student not found",
                    status  = HttpStatusCode.NotFound
                )
            }
        }

        // Exercise 5
        get("/api/stock/{symbol}") {
            val symbol = call.parameters["symbol"] ?: "AAPL"
            val stock = Stock(symbol, 150.25)
            call.respond(stock)
        }

        // Exercise 4
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
