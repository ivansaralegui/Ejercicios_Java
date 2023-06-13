FROM openjdk:20
EXPOSE 8080
ADD /target/*.jar /spring.jar
ENTRYPOINT ["java","-jar","/spring.jar"]