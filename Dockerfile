FROM eclipse-temurin:21
RUN mvn clean package

FROM openjdk:21
COPY target/postgresql.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
