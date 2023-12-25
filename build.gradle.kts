plugins {
    id("java")
}

group = "com.zingplay.tiennm5"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.14.1")
    implementation("org.apache.logging.log4j:log4j-core:2.14.1")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.couchbase.client:java-client:3.5.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
