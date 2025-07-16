# 1단계: Gradle을 사용하여 애플리케이션 빌드
FROM gradle:8.5.0-jdk17-alpine AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .

# --- 변경된 부분 ---
# 'readforce' 하위 폴더로 이동하여 빌드 준비
WORKDIR /home/gradle/src/readforce

RUN gradle build -x test --no-daemon

# 2단계: 빌드된 결과물만 사용하여 가벼운 최종 이미지 생성
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# --- 변경된 부분 ---
# 올바른 경로에서 .jar 파일 복사
COPY --from=build /home/gradle/src/readforce/build/libs/*.jar app.jar

EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]