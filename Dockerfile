FROM maven:3.8.5-openjdk:21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
COPY --from=build /target/postgresql.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
