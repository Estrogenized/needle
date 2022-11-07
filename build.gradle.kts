plugins {
    java
    `java-library`
}

group = "moe.queery"
version = "1.0.0-release.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "org.jetbrains", name = "annotations", version = "23.0.0")
    implementation(group = "it.unimi.dsi", name = "fastutil", version = "8.5.9")
    implementation(group = "com.nulab-inc", name="zxcvbn", version="1.7.0")
}
