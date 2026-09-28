# Étape 1 : build du projet avec Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : image finale, légère, juste pour exécuter le jar
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "app.jar"]