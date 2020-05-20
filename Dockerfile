FROM openjdk:11 as builder

WORKDIR /tmp
COPY . /tmp

RUN chmod +x gradlew
RUN ./gradlew clean build --no-daemon --debug-jvm -x test

FROM openjdk:11-jre

WORKDIR /app
ENV STATIC_FILES_FOLDER=/app/static/

COPY --from=builder /tmp/build/libs/*.jar /app

EXPOSE 8080

RUN mkdir -p /app/static

CMD java -jar /app/*.jar
