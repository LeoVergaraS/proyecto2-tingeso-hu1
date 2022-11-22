FROM openjdk:17 
ARG JAR_FILE=target/subida-service.jar
COPY ${JAR_FILE} subida-service.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","/subida-service.jar"]
