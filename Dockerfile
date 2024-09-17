FROM eclipse-temurin:21-jre-jammy

# Install curl, git, maven, zstd, bzip2
RUN apt-get update \
    && apt-get install -y curl \
    && apt-get install -y git \
    && apt-get install -y maven \
    && apt-get install -y zstd \
    && apt-get install -y bzip2 \
    && apt-get clean

EXPOSE 8080
EXPOSE 5106
EXPOSE 7000

COPY ./start-backend.sh /start-backend.sh
RUN sed -i -e 's/\r$//' /start-backend.sh
RUN chmod +x /start-backend.sh

WORKDIR /app
RUN pwd
COPY /target/*.jar application.jar

ENTRYPOINT ["/start-backend.sh"]
