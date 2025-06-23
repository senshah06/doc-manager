# Stage 1: Build the application
FROM maven:3.9.7-amazoncorretto-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM amazoncorretto:17
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Heroku sets the PORT environment variable
ENV PORT=8080
EXPOSE $PORT

# Run the application
CMD ["java", "-jar", "app.jar"]
