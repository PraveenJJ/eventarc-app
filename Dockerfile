# Use a lightweight Java 21 runtime image
FROM eclipse-temurin:21-jdk-alpine

# Set app directory in container
WORKDIR /app

# Copy the JAR file into the image
COPY target/eventarc-app-0.0.1.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","/app/app.jar"]