FROM openjdk:8
MAINTAINER mmacuka
COPY . /app
WORKDIR /app
RUN ./mvnw clean package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]