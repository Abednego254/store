# syntax=docker/dockerfile:1.6        # (ku‑enable BuildKit mount cache)

# ---------- Stage 1: build ----------
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# 1. Copy wrapper & POM tu kwanza
COPY pom.xml ./
COPY mvnw ./
COPY .mvn  .mvn

# 2. Mount ~/.m2 as a cache layer, then resolve deps + build
#    -ntp  = no transfer progress (less chatty)
#    MAVEN_OPTS hu‑increase timeouts & retries
RUN --mount=type=cache,target=/root/.m2 \
    MAVEN_OPTS="-Dmaven.wagon.http.retryHandler.count=10 \
                -Dmaven.wagon.httpconnectionManager.soTimeout=60000 \
                -Dmaven.wagon.httpconnectionManager.connectionTimeout=60000" \
    ./mvnw -B -ntp dependency:resolve

# 3. Sasa ongeza source yote na jenge JAR
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 \
    MAVEN_OPTS="-Dmaven.wagon.http.retryHandler.count=10 \
                -Dmaven.wagon.httpconnectionManager.soTimeout=60000 \
                -Dmaven.wagon.httpconnectionManager.connectionTimeout=60000" \
    ./mvnw -B -ntp clean package -DskipTests

# ---------- Stage 2: runtime ----------
FROM gcr.io/distroless/java17-debian12
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
USER nonroot
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
