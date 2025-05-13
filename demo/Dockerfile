# 使用官方的 OpenJDK 17 作為基礎鏡像
FROM openjdk:17-slim

# 設定工作目錄
WORKDIR /app

# 複製 JAR 檔案到容器中
COPY target/*.jar app.jar

# 設定環境變數
ENV JAVA_OPTS=""

# 暴露端口
EXPOSE 8080

# 啟動應用程式
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
