# Multi-stage Dockerfile for Kotlin application
# This Dockerfile builds the application from source inside Docker,
# so you don't need to install Java or Gradle locally.
#
# Stage 1: Build stage - uses Gradle image with JDK to build the application
FROM gradle:8.5-jdk17 AS builder

WORKDIR /app

# Copy Gradle configuration files
COPY build.gradle.kts settings.gradle.kts ./

# Copy source code
COPY src src

# Build the application using Gradle from the base image
# Note: In some corporate/CI environments with SSL inspection, you may need to
# configure certificates. In such cases, pre-build locally with ./gradlew build
# and use COPY build/libs/*.jar instead of RUN gradle build
RUN gradle build --no-daemon

# Stage 2: Runtime stage - uses minimal JRE for smaller final image
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy only the built JAR from builder stage (not source code or build tools)
COPY --from=builder /app/build/libs/learn-kotlin-1.0.0.jar /app/learn-kotlin.jar

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "/app/learn-kotlin.jar"]
