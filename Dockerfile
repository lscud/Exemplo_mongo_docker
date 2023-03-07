FROM maven:3.8.6-openjdk-8-slim As build
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip


# Instale o cliente MySQL
#RUN apk add --no-cache mysql-client

FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]


