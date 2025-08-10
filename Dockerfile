# Use Eclipse Temurin JDK 17 (lightweight Alpine version)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for dependency caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Give execute permission to Maven wrapper
RUN chmod +x mvnw

# Download dependencies (this will cache them)
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src src

# Package the application (create JAR file)
RUN ./mvnw clean package -DskipTests

# Run the Spring Boot JAR file
CMD ["java", "-jar", "target/JobPost-0.0.1-SNAPSHOT.jar"]
