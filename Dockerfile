FROM openjdk:11.0.16-slim
RUN mkdir -p /opt/arqui_software/logs
VOLUME /opt/arqui_software/logs
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java", \
            "-cp",                 \
            "app:app/lib/*",                 \
            "com/example/todo/TodoApplication"]

