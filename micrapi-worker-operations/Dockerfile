#commands to run 

# mvn clean package
# docker build -t micropi-oracle-crud:latest .
# docker run -d -p 8080:8080 micropi-oracle-crud:latest
# -d for detach mode
#docker stop continer_id

# Use Java 17 JDK slim image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the correct jar file
COPY target/oracleDB-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
