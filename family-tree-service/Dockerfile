FROM openjdk:8
ENV JAVA_APP_JAR java-container.jar
ENV AB_OFF true
ADD target/family-service.jar family-service.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "family-service.jar"]