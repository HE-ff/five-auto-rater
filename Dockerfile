FROM openjdk:11-slim as build
COPY . /home/five-autorater
WORKDIR /home/five-autorater
RUN ./gradlew build

FROM openjdk:12-oracle as run
RUN  curl https://ipapi.co/timezone > /etc/timezone
RUN groupadd -r gk && useradd -r -g gk gk
COPY --from=build /home/five-autorater/build/libs/*.jar /home/gk/five-autorater.jar
RUN chown -R gk:gk  /home/gk
USER gk:gk
WORKDIR /home/gk
ENTRYPOINT ["java","-jar","five-autorater.jar"]
