# OJ在线判题系统

[toc]

## 项目简介

### 项目介绍

基于**Vue3**+**Arco Design+SpringBoot+SpringCloud微服务**+**Docker**+**RabbitMQ**的编程题目在线评测系统（OJ）系统

系统能够根据管理员预设的题目用例对用户提交的代码进行执行和测评；系统中自主实现的**代码沙箱**可作为独立服务供其他开发者调用，并实现了对代码进行微服务重构

#### 核心业务流程

![image-20240825143232820](C:\Users\山兮\AppData\Roaming\Typora\typora-user-images\image-20240825143232820.png)

![image-20240825143312171](C:\Users\山兮\AppData\Roaming\Typora\typora-user-images\image-20240825143312171.png)

### 页面展示

登录页面

![image-20240825141653578](C:\Users\山兮\AppData\Roaming\Typora\typora-user-images\image-20240825141653578.png)

主页展示

![image-20240825141821824](C:\Users\山兮\AppData\Roaming\Typora\typora-user-images\image-20240825141821824.png)

管理题目

![image-20240825141846681](C:\Users\山兮\AppData\Roaming\Typora\typora-user-images\image-20240825141846681.png)

题目提交信息

![image-20240825141901576](C:\Users\山兮\AppData\Roaming\Typora\typora-user-images\image-20240825141901576.png)

题目创建

![image-20240825141926656](C:\Users\山兮\AppData\Roaming\Typora\typora-user-images\image-20240825141926656.png)

题目浏览

![image-20240825142037269](C:\Users\山兮\AppData\Roaming\Typora\typora-user-images\image-20240825142037269.png)



### 功能模块

* 题目模块
  * 创建题目（管理员）
  * 删除题目（管理员）
  * 修改题目（管理员）
  * 搜索题目（全用户）
  * 在线做题（支持多种语言，暂只实现java语言的判题）
  * 提交题目代码
  * 判题结果呈现
* 用户模块
  * 注册
  * 登录
* 判题模块
  * 提交判题
  * 错误处理
  * 自主实现**代码沙箱**（安全沙箱）
  * 开放接口（提供一个独立的新服务）

## 技术选型

### 前端

* Vue3、Vue-CLI脚手架、Vuex状态管理
* Arco Design 组件库
* 前端工程化：ESLint + Prettier + TypeScript
* 手写前端项目模板（通用布局、权限管理、状态管理、菜单生成）
* Markdown 富文本编辑器
* Monaco Editor 代码编辑器
* OpenAPI前端代码生成

### 后端

* Java SpringCloud + SpringCloudAlibaba微服务
* SpringBoot
* Java进程控制
* java安全管理器
* Docker代码沙箱实现
* 虚拟机+远程开发
* Mysql数据库、MyBatis-plus以及MybatisX自动代码生成
* Redis分布式Session
* RabbitMQ消息队列
* 多种设计模式
  * 策略模式
  * 工厂模式
  * 代理模式
  * 模板方法模式


## 快速上手

### MySQL 数据库

1）修改 `application.yml` 的数据库配置为你自己的：

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/my_db
    username: root
    password: 123456
```

2）执行 `sql/create_table.sql` 中的数据库语句，自动创建库表

3）启动项目，访问 `http://localhost:8101/api/doc.html` 即可打开接口文档，不需要写前端就能在线调试接口了~

![](doc/swagger.png)

### Redis 分布式登录

1）修改 `application.yml` 的 Redis 配置为你自己的：

```yml
spring:
  redis:
    database: 1
    host: localhost
    port: 6379
    timeout: 5000
    password: 123456
```

2）修改 `application.yml` 中的 session 存储方式：

```yml
spring:
  session:
    store-type: redis
```

3）移除 `MainApplication` 类开头 `@SpringBootApplication` 注解内的 exclude 参数：

修改前：

```java
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
```

修改后：


```java
@SpringBootApplication
```

### 前端接口生成

1）安装请求工具类axios

```shell
npm install axios

```

2)编写调用后端代码

```shell
#首先安装
npm install openapi-typescript-codegen --save-dev
#执行命令
openapi --input http://localhost:8121/api/v2/api-docs --output ./generated --client axios
```

3）直接使用生成的service代码，直接调用函数发送请求即可，比如获取登录信息

```tsx
// 从远程请求获取登录信息
const res = await UserControllerService.getLoginUserUsingGet();
if (res.code === 0) {
  commit("updateUser", res.data);
} else {
  commit("updateUser", {
    ...state.loginUser,
    userRole: ACCESS_ENUM.NOT_LOGIN,
  });
}
```

