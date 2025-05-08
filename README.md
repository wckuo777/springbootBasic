# 🧾 Spring Boot Orders API 專案

這是一個使用Eclipse **Spring Boot** 建立的後端 RESTful API 專案，Demo CRUD 操作與價格查詢功能，並搭配 DTO 與 Swagger 文件。

---

## 🛠 使用技術

| 技術 | 說明 |
|------|------|
| Java 8 | 開發語言 |
| Spring Boot | 核心框架 |
| Spring Web | REST API 建立 |
| Spring Data JPA | 資料存取與 ORM 映射 |
| MySQL | 後端資料庫 |
| Swagger (springdoc-openapi) | 自動產生 API 文件 |
| Lombok | 精簡程式碼（自動產生 getter/setter） |

---

## 📦 API 功能總覽

| 方法 | 路徑 | 說明 |
|------|------|------|
| `POST` | `/orders` | 新增訂單 |
| `GET` | `/orders` | 查詢所有訂單 |
| `GET` | `/orders/{id}` | 查詢指定訂單 |
| `PUT` | `/orders/{id}` | 更新訂單 |
| `DELETE` | `/orders/{id}` | 刪除訂單 |
| `GET` | `/orders/with-age` | 查詢包含顧客年齡的訂單（使用 DTO） |
| `POST` | `/orders/price/query` | 依價格條件查詢訂單（GREATER / LESS / EQUAL / BETWEEN）|

---

## 🚀 快速啟動

1️⃣ 建立 MySQL 資料庫（資料庫名稱：`bentest`）  
執行 SQL 腳本建立資料表與測試資料：

```bash
bentest/my_customer.sql
bentest/my_order.sql
```

2️⃣ 修改 application.properties 連線設定：
``` yours 
spring.datasource.url=jdbc:mysql://localhost:3306/bentest
spring.datasource.username=your_usernawmw
spring.datasource.password=your_password
```

3️⃣ 啟動專案api file：
```
run as > Spring boot App
```

🔍 Swagger 文件
啟動後可透過瀏覽器開啟 API 文件：
http://localhost:8080/swagger-ui/index.html




