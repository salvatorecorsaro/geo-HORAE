FROM openjdk
ADD target/dgeo-horae-1.0.jar geo-horae-1.0.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "geo-horae-1.0.jar"]
