FROM openjdk:8
EXPOSE 8085
ADD target/demo-jenkins.jar demo-jenkins.jar
ENTRYPOINT ["java", "-jar",, "/demo-jenkins.jar"]