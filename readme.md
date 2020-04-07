### 权限管理系统的设计

#### 技术选型

* `AdminLTE`作为`view`
* 采用`ssm+spring-security`的方式，数据库采用`Mysql`
* 使用`PageHelper`作为分页工具

#### 新知识

* 使用`spring-security`作为**登录认证**以及**页面权限控制**以及**服务器**权限控制
* 日志记录系统

#### 设计过程

* 数据库和数据表的设计

* 建立`maven`工程，配置`pom.xml`文件，导入依赖的坐标

* 建立`applicationConfig.xml`文件，作为`spring`的配置文件，整合s`pring`和`mybatis`

  * 配置文件中使用`<component-scan>`标签配置注解扫描，扫描`service` 和`dao`包
  * 使用`v2.c3p0`配置连接池，此处需要一个数据库的配置文件`jdbcConfig.properties`
  * 整合`mybatis`,配置`sqlSessionFactoryBean`
  * 配置`PageHelper`插件
  * 配置声明式事务
  * 使用`MapperScannerConfigurer`配置扫描`dao`接口

* 编写`springmvc.xml`

  * 配置扫描包的规则，只扫描`controller`包
  * 配置视图解析器，指定`jsp`文件的位置和后缀名
  * 配置静态资源不过滤
  * 使用`mvc:annotation-driven`配置注解支持
  * 使用`aop:aspect-autoproxy`配置`AOP`注解支持

* 编写`springsecurity.xml`文件

  * 配置具体的拦截规则，拦截路径，访问系统需要具备的权限
  * 定义具体的跳转页面
  * 配置注销用户的跳转
  * 配置加密方式

* 编写具体的`service` `dao` `controller`和`domain`

  * 在需要使用分页的地方配置

    ```
    List<Orders> ordersList = ordersService.findAll(page, size);
    PageInfo pageInfo = new PageInfo(ordersList);
    ```

  * 在页面权限控制的地方使用注解

    `<security:authorize access="hasRole('ADMIN')">`

    表示该内容对拥有`ADMIN`权限的用户可见

  * 在服务器上使用注解限制用户对方法的访问

    ```
    @Secured("ROLE_ADMIN")
    ```

    表示拥有`ADMIN`权限的用户才可以访问该方法

* **数据库的多表查询以及定义返回结果**