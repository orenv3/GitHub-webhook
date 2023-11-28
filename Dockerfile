FROM openjdk:17

ENV PORT 8080

RUN mkdir -p /app

COPY target/*.jar /app

EXPOSE 8080

ENTRYPOINT ["java","-jar", "/app/auditDemo-0.0.3-SNAPSHOT.jar"]