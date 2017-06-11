FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD suranku-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV DB_NAME db
ENV DB_USER postgres
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]