FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app
# Copy only pom.xml to download dependencies first
COPY pom.xml .
# Pre-fetch all dependencies
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package && ls -la target

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/spring-docker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]