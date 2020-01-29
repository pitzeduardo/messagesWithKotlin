package com.pitzdev.kotlinapi

import com.pitzdev.kotlinapi.services.ConsumerService
import com.rabbitmq.client.ConnectionFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinApiApplication

fun main(args: Array<String>) {
    runApplication<KotlinApiApplication>(*args)

    val consumerService = ConsumerService()
    consumerService.holderCreationNotificationListener()
}
