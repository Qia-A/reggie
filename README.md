# reggie

项目介绍 
该项目是一个外卖点餐系统，通过git管理项目，并用nginx部署前端，tomcat部署后端，使用mysql主从复制，从库读取，主库写入，再用shell脚本部署到服务器上。 
菩提阁主要包括系统管理后台和移动端应用两部分。
系统管理后台主要提供给餐饮企业内部员工使用，用于对餐厅的分类、菜品、套餐、订单、员工等进行管理维护。移动端应用主要提供给消费者使用，可以在线浏览菜品、添加购物车、下单等。

主要技术栈包括：

- **后端框架**: Spring Boot 2.4.5
- **数据库**: MySQL
- **持久层框架**: MyBatis Plus 3.4.2
- **数据库连接池**: Druid 1.1.23
- **缓存**: Redis
- **工具类**: Lombok, FastJSON, Apache Commons Lang
- **Java版本**: 1.8

项目采用典型的MVC架构，包含controller、service、mapper、entity等分层结构。

# 构建和运行

## 环境要求

- Java 8
- Maven 3.x
- MySQL 5.7+
- Redis

## 配置

在 `src/main/resources/application.yml` 中配置数据库和Redis连接信息：

```yaml
spring:
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/reggie?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true
      username: root
      password: "000000"
  redis:
    host: 172.17.2.94
    port: 6379
    password: root@123456
    database: 0
```

## 构建项目

```bash
mvn clean package
```

## 运行项目

```bash
mvn spring-boot:run
```

或者

```bash
java -jar target/reggie_take_out-1.0-SNAPSHOT.jar
```

项目默认运行在 `http://localhost:8080`。

# 开发约定

- 使用Lombok简化JavaBean代码（如@Data注解）
- 使用MyBatis Plus简化数据库操作
- 使用Druid作为数据库连接池
- 使用Redis进行缓存
- 使用FastJSON进行JSON序列化/反序列化
- 使用Apache Commons Lang处理字符串等工具类操作
- 使用Slf4j进行日志记录
