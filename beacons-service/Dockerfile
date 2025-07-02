FROM eclipse-temurin:21-jdk
ARG JAR_FILE=target/beacons-service-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]