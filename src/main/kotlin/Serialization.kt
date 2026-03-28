package com.exercise

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable


@Serializable
data class Stock(
    val symbol: String,
    val price: Double
)

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
