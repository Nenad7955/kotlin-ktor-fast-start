package com.example

import com.example.plugins.City
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        install(ContentNegotiation) {
            json()
        }

        val city = City("A", 1)

        client.post("/cities") {
//            contentType(ContentType.Application.Json)
            setBody(city)
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
            println()
        }

    }
}
