# Use a lightweight Java 17 image as the base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY /target/epdcblog-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8025

# Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
