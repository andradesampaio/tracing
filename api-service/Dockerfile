FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.11_9
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/application.jar"]
