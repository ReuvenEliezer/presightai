FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY target/mongo-1.0.jar mongo-1.0.jar
#ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n
#ENTRYPOINT exec  java -jar app.jar
CMD ["java", "-jar","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "app.jar"]