# Docker file spring boot - java 11

FROM adoptopenjdk:11-jre-hotspot

EXPOSE 8080

RUN mkdir -p /app/

ADD build/libs/challengeSkuProduct-0.0.1-SNAPSHOT.jar /app/challengeSkuProduct-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/challengeSkuProduct-0.0.1-SNAPSHOT.jar"]