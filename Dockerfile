FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# This forces Docker to grab the exact JAR built by your latest pom.xml
COPY target/leave-management-system-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]