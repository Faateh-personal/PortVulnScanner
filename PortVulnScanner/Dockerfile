# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file and other resources into the container
COPY target/PortVulnScanner.jar /app
COPY src/main/resources/vulnerabilities.json /app/resources/
COPY src/main/resources/config.properties /app/resources/

# Run the application
CMD ["java", "-jar", "PortVulnScanner.jar"]
