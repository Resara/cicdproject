# Use a lightweight JDK base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file from Maven build
COPY target/myservice-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]