FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} springbootmvc.jar

ENTRYPOINT ["java", "-jar", "/springbootmvc.jar"]