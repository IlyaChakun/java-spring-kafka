######## 1. Maven build stage ########
FROM maven:3.8.3-openjdk-17 as maven_build
WORKDIR /app

# copy pom
COPY pom.xml .

# resolve maven dependencies
RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r target/

# copy source
COPY src ./src

# build the app (no dependency download here)
RUN mvn clean package  -Dmaven.test.skip

######## 1. Run application stage ########
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=maven_build /app/target/*.jar ./producer.jar

ENTRYPOINT java -jar producer.jar \
                    --spring.kafka.bootstrap-servers=$BROKER

EXPOSE 8080