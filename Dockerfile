FROM eclipse-temurin:25-jre-jammy

RUN apt-get update \
 && apt-get install -y --no-install-recommends curl \
 && rm -rf /var/lib/apt/lists/* \
 && useradd -ms /bin/bash appuser

USER appuser
WORKDIR /app

COPY --chown=appuser:appuser target/account-ui-*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]