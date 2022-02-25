FROM openjdk:11

COPY ["./target/clients-0.0.1-SNAPSHOT.jar", "/usr/app/"]

CMD ["java", "-jar", "/usr/app/clients-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080