# MiniMUD Game

這是一個基於 Spring Boot 的簡單 MUD（Multi-User Dungeon）遊戲。

## 功能特點

- 基於 Web 的遊戲介面
- RESTful API 設計
- 支援多種遊戲指令
- 完整的遊戲狀態管理
- Docker 容器化部署

## 技術棧

- Java 17
- Spring Boot 3.4.4
- Maven
- Docker
- Azure Cloud (選配)

## 快速開始

### 必要條件

- Java 17 或更高版本
- Maven 3.6 或更高版本
- Docker (如果需要容器化運行)

### 本地開發

1. 克隆專案：
```bash
git clone https://github.com/your-username/miniMUD.git
cd miniMUD
```

2. 編譯並運行：
```bash
mvn clean install
mvn spring-boot:run
```

3. 訪問遊戲：
打開瀏覽器訪問 http://localhost:8080

### Docker 部署

1. 建構 Docker 映像：
```bash
docker-compose build
```

2. 運行容器：
```bash
docker-compose up -d
```

### Azure 部署

1. 設定 Azure 憑證：
```bash
az login
```

2. 部署到 Azure Container Apps：
```bash
mvn azure-container-apps:deploy
```

## 遊戲指令

- `look` - 查看當前房間
- `move <direction>` - 移動到指定方向
- `attack` - 攻擊當前房間的怪物
- `skill fireball` - 使用火球術
- `use potion` - 使用治療藥水
- `exit` - 退出遊戲

## 專案結構

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── mycompany/
│   │           └── app/
│   │               └── miniMUD/
│   │                   ├── command/    # 命令模式實現
│   │                   ├── controller/ # RESTful API
│   │                   ├── model/      # 遊戲模型
│   │                   └── service/    # 遊戲邏輯
│   └── resources/
│       ├── static/     # Web 前端
│       └── templates/  # 視圖模板
```

## 開發說明

- 使用命令模式處理遊戲指令
- 完整的 OOP 設計
- RESTful API 設計
- 前端使用原生 JavaScript

## 部署注意事項

1. 確保已安裝所有必要軟體
2. 檢查 application.properties 中的配置
3. Azure 部署需要更新 pom.xml 中的 Azure 配置

## 貢獻指南

1. Fork 專案
2. 創建特性分支
3. 提交變更
4. 推送到分支
5. 建立 Pull Request

## 授權

[MIT License](LICENSE)