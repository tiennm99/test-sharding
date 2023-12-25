package com.zingplay.tiennm5;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaMessageSender {
    public static void main(String[] args) {
        // Set up the properties for the Kafka producer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Replace with your Kafka server addresses
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Send a message to the "test" topic
        producer.send(new ProducerRecord<String, String>("test", "key", "value"));

        // Close the producer
        producer.close();
    }
}
