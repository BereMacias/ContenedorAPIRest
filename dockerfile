FROM openjdk:17-jdk-alpine
COPY target/helados-0.0.1-SNAPSHOT.jar helado_app.jar
ENTRYPOINT [ "java", "-jar", "helado_app.jar" ]