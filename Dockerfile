# Use base image
FROM openjdk:21-jdk

# Set working directory in container
WORKDIR /app

# Copy JAR file into container
COPY target/record-shop-api.jar /app/record-shop-api.jar

# Port on which the application will run
EXPOSE 8080

# Run JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
