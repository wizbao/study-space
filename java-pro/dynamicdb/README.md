# 配置动态数据源
## 步骤
1、引入依赖
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
    <version>3.6.1</version>
</dependency>
```
2、application.xml配置文件中配置数据源信息
```yaml
spring:
  datasource:
    dynamic:
      primary: master
      datasource:
        master:
          driver-class-name: com.mysql.cj.jdbc.Driver
          url: jdbc:mysql://localhost:3306/sakila
          username: root
          password: qlk123456
        slave:
          driver-class-name: com.mysql.cj.jdbc.Driver
          url: jdbc:mysql://localhost:3306/world
          username: root
          password: qlk123456
# 输入sql日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```
3、在需要切换数据源的方法或实现类上使用 **@DS("数据源")** 注解

## 约定
- 本框架只做 切换数据源 这件核心的事情，并不限制你的具体操作，切换了数据源可以做任何CRUD。
- 配置文件所有以下划线 _ 分割的数据源 首部 即为组的名称，相同组名称的数据源会放在一个组下。
- 切换数据源可以是组名，也可以是具体数据源名称。组名则切换时采用负载均衡算法切换。
- 默认的数据源名称为 master ，你可以通过 spring.datasource.dynamic.primary 修改。
- 方法上的注解优先于类上注解。
- DS支持继承抽象类上的DS，暂不支持继承接口上的DS。
