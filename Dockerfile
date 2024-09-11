# Use base image
FROM openjdk:21-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy the JAR file into the container
COPY target/Record-Shop-API-0.0.1-SNAPSHOT.jar /app/record-shop-api.jar

# Expose the port that the application will run on
EXPOSE 8080

# Define the entry point for the Docker container
ENTRYPOINT ["java", "-jar", "/app/record-shop-api.jar"]
