FROM maven:4-eclipse-temurin:21
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
COPY --from=build /target/postgresql.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
