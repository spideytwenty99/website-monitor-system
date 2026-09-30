FROM eclipse-temurin:23-jre

WORKDIR /app

COPY out/artifacts/Web_jar/Web.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]