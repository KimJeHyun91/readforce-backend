# 1단계: Gradle을 사용하여 애플리케이션 빌드
FROM gradle:8.5.0-jdk17-alpine AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle build -x test --no-daemon

# 2단계: 빌드된 결과물만 사용하여 가벼운 최종 이미지 생성
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar

# Render가 제공하는 포트를 사용하도록 설정
EXPOSE 10000

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]