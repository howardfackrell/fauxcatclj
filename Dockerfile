FROM clojure:openjdk-8-lein as builder

COPY . .

RUN lein uberjar

CMD ["sh"]


FROM openjdk:8-alpine

COPY --from=builder /tmp/target/uberjar/fauxcatclj.jar /fauxcatclj/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/fauxcatclj/app.jar", "-p", "$PORT"]
