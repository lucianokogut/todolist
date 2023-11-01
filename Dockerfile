FROM ubuntu:latest AS image

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=image target/todolist-0.0.1.jar todo-list.jar

ENTRYPOINT [ "java", "-jar", "todo-list.jar" ]