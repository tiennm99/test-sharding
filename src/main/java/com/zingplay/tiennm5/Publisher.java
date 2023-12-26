package com.zingplay.tiennm5;

import redis.clients.jedis.Jedis;

public class Publisher {
    public void publish(String channel, String message) {
        try (Jedis jedis = new Jedis("localhost")) {
            jedis.publish(channel, message);
        }
    }

    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.publish("test", "Hello world!");
    }
}
