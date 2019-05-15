FROM java:8-jdk-alpine
RUN mkdir pathfinder-back-end
COPY . /pathfinder-back-end/
RUN apk update && apk add bash
WORKDIR /pathfinder-back-end
RUN chmod +x ./gradlew
RUN ./gradlew build
WORKDIR /pathfinder-back-end/build/libs
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pathfinder-0.0.1-SNAPSHOT.jar"]
