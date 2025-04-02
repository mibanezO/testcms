FROM amazoncorretto:21-alpine AS base

FROM base AS builder

WORKDIR /root/.mvn

ADD . /app

WORKDIR /app

RUN ./mvnw clean package

FROM base AS runner

COPY --from=builder /app/target/test-cms.jar .

CMD ["java","-jar","/test-cms.jar"]
