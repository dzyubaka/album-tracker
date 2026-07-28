FROM eclipse-temurin:25
COPY keystore.p12 .
COPY build/libs/album-tracker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
