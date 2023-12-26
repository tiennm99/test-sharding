package com.zingplay.tiennm5;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscriber {
    public void subscribe(String channel) {
        try (Jedis jedis = new Jedis("localhost")) {
            jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    System.out.println("Received message: " + message);
                }
            }, channel);
        }
    }

    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber();
        subscriber.subscribe("test");
    }
}
