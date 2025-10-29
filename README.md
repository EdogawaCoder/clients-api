
  

## Overview  

This project was developed as part of a personal study plan to strengthen backend development skills using **Java 21**, **Spring Boot 3.5.7**, and **PostgreSQL**.  
It provides a simple API for managing client data, including creation, update, search, and deletion.  
The system uses a manual **JDBC** implementation through a `ConnectionFactory` to handle database operations, reinforcing the understanding of SQL and connection handling before using ORM frameworks like JPA or Hibernate.  

### Purpose  

The main goal of this project is educational — to explore and practice:  
- JDBC and prepared statements in Java  
- Manual database connection management  
- CRUD operations with PostgreSQL  
- Clean and modular backend architecture (entities, repositories, factories)  

### Technologies Used  

- Java 21  
- Spring Boot 3.5.7  
- PostgreSQL  
- Maven  
- JDBC  
- UUID  

### Project Structure  

```
src/main/java/com/edogawa/apiClients
│
├── entities/
│   └── Client.java           # Data model for clients
│
├── repositories/
│   └── ClientsRepository.java # Handles CRUD operations via JDBC
│
└── factories/
    └── ConnectionFactory.java # Manages database connections
```

### Database Schema  

```sql
CREATE TABLE clients (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    phone VARCHAR(20),
    born_date DATE,
    register_date DATE
);
```

### How to Run  

1. Clone this repository:  
   ```bash
   git clone https://github.com/EdogawaCoder/clients-api.git
   ```
2. Navigate to the project directory:  
   ```bash
   cd clients-api
   ```
3. Run the application:  
   ```bash
   mvn spring-boot:run
   ```
4. Ensure PostgreSQL is running and accessible with credentials configured in  
   `ConnectionFactory.java`  

### 日本語版  

このプロジェクトは、**Java 21**, **Spring Boot 3.5.7**, **PostgreSQL** を使用して構築された学習用バックエンドAPIです。  
顧客データの登録、更新、検索、削除を行うことができます。  
ORMを使用せず、**JDBC**を用いた手動の接続処理を実装し、SQLおよびデータベース操作の基礎理解を深めることを目的としています。  

#### 主な目的  
- JavaでのJDBCとプリペアドステートメントの使用  
- データベース接続の手動管理  
- PostgreSQLを使ったCRUD操作  
- クリーンでモジュール化されたアーキテクチャ設計  

#### 使用技術  
- Java 21  
- Spring Boot 3.5.7  
- PostgreSQL  
- Maven  
- JDBC  
- UUID  
