FROM openjdk:17-slim

COPY ./target/HelloDemo-1.0.0.jar /app/
WORKDIR /app

CMD ["java", "-jar", "HelloDemo-1.0.0.jar"]

