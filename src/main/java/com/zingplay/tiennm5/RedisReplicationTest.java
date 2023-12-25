package com.zingplay.tiennm5;

import org.apache.commons.lang3.RandomStringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

public class RedisReplicationTest {
    public static void main(String[] args) {
        // Replace with your actual master and slave server IP addresses
        String masterIp = "157.245.197.222";
        String slaveIp = "165.22.101.163";
        int timeout = 3000; // Timeout in milliseconds

        // Create Jedis instances for master and slave servers
        Jedis master = new Jedis(new HostAndPort(masterIp, 6379));
        Jedis slave = new Jedis(new HostAndPort(slaveIp, 6379));

        String randomKey = RandomStringUtils.randomAlphanumeric(10);
        String randomValue = RandomStringUtils.randomAlphanumeric(10);

        // Set a key on the master server
        master.set(randomKey, randomValue);

        // Get the key from the slave server
        String value = slave.get(randomKey);

        // Print the value
        System.out.println("Value from slave: " + value);
        if (value.equals(randomValue)) {
            System.out.println("Replication is working correctly");
        } else {
            System.out.println("Replication is not working correctly");
        }

        // Close the Jedis instances
        master.close();
        slave.close();
    }
}
