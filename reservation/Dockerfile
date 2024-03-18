# syntax=docker/dockerfile:1.4
# the first stage of our build will extract the layers
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

# Create user to run app as (instead of root)
RUN addgroup -S app && adduser -S app -G app
# Use user "app"
USER app

WORKDIR /workdir/server
COPY pom.xml /workdir/server/pom.xml
RUN mvn dependency:go-offline

COPY src /workdir/server/src
RUN mvn install

FROM builder AS prepare-production
RUN mkdir -p target/dependency
WORKDIR /workdir/server/target/dependency
RUN jar -xf ../*.jar

# the second stage of our build will copy the extracted layers
FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ARG DEPENDENCY=/workdir/server/target/dependency

# FROM eclipse-temurin:17-jre as builder
# WORKDIR application
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} application.jar
# RUN java -Djarmode=layertools -jar application.jar extract

# COPY --from=builder application/dependencies/ ./
# COPY --from=builder application/spring-boot-loader/ ./
# COPY --from=builder application/snapshot-dependencies/ ./
# COPY --from=builder application/application/ ./
# ENTRYPOINT [ "java", "org.springframework.boot.loader.JarLauncher" ]
COPY --from=prepare-production ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=prepare-production ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=prepare-production ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.ubluetech.reservation.ReservationApplication"]
