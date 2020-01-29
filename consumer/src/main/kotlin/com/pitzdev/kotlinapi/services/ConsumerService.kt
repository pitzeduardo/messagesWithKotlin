package com.pitzdev.kotlinapi.services

import com.rabbitmq.client.AMQP
import org.springframework.stereotype.Service;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope

@Service
class ConsumerService() {

    fun holderCreationNotificationListener() {
        val queueName = "createdHolder"
        val factory = ConnectionFactory()
        factory.host = "localhost"

        val connection = factory.newConnection()
        val channel = connection.createChannel()

        channel.queueDeclare(queueName, false,false,false,null)
        val consumer = object : DefaultConsumer(channel) {
            override fun handleDelivery(consumerTag: String, envelope: Envelope, properties: AMQP.BasicProperties, body: ByteArray) {
                val message = String(body, charset("UTF-8"))
                println(" >> Notificado: '$message'")
            }
        }
        channel.basicConsume(queueName, true, consumer)
    }
}