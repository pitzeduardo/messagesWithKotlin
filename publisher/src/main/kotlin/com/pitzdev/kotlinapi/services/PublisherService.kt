package com.pitzdev.kotlinapi.services

import org.springframework.stereotype.Service;
import com.rabbitmq.client.ConnectionFactory;

@Service
class PublisherService() {

    fun notificateHolderCreation(holderId: Long) {
        sentMessage(holderId, "createdHolder")
    }

    private fun sentMessage(holderId: Long, queueName: String) {
        val factory = ConnectionFactory()
        factory.host = "localhost"

        val connection = factory.newConnection()
        val channel = connection.createChannel()

        channel.queueDeclare(queueName, false, false, false, null)
        channel.basicPublish("", queueName, null, holderId.toString().toByteArray())

        println(" basicPublish: $holderId")

        channel.close()
        connection.close()
    }
}