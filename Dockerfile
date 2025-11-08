# Dockerfile for Kotlin application
# Build the JAR first using: ./gradlew build
# Then build the Docker image: docker build -t learn-kotlin:latest .

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the pre-built fat JAR file
COPY build/libs/learn-kotlin-1.0.0.jar /app/learn-kotlin.jar

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "/app/learn-kotlin.jar"]
