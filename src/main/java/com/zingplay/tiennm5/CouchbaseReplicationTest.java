package com.zingplay.tiennm5;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import org.apache.commons.lang3.RandomStringUtils;

public class CouchbaseReplicationTest {

  private Cluster cluster1;
  private Cluster cluster2;
  private Bucket bucket1;
  private Bucket bucket2;

  public static void main(String[] args) {
    CouchbaseReplicationTest test = new CouchbaseReplicationTest();
    test.setup();
    test.testReplication();
  }

  public void setup() {
    // Connect to Couchbase nodes
    cluster1 = Cluster.connect("139.59.125.14", "admin", "123456");
    cluster2 = Cluster.connect("128.199.140.121", "admin", "123456");
    bucket1 = cluster1.bucket("tiennm5");
    bucket2 = cluster2.bucket("tiennm5");
  }

  public void testReplication() {
    // Perform operations and check replication
    Collection collection1 = bucket1.defaultCollection();
    Collection collection2 = bucket2.defaultCollection();

    String randomKey = RandomStringUtils.randomAlphanumeric(10);
    String randomValue = RandomStringUtils.randomAlphanumeric(10);
    collection1.insert(randomKey, randomValue);

    GetResult result = collection2.get(randomKey);

    System.out.println(result.contentAs(String.class));
    // Check if the document is successfully retrieved
    if (result.contentAs(String.class).equals(randomValue)) {
      System.out.println("Replication is working correctly");
    } else {
      System.out.println("Replication is not working correctly");
    }

    // Delete the document
    // collection1.remove(randomKey);
  }
}
