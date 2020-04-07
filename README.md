# Authority-management-system
spring+spring-mvc+mybatis+spring-security+mysql
权限管理系统的设计
技术选型
AdminLTE作为view
采用ssm+spring-security的方式，数据库采用Mysql
使用PageHelper作为分页工具
新知识
使用spring-security作为登录认证以及页面权限控制以及服务器权限控制
日志记录系统
设计过程
数据库和数据表的设计

建立maven工程，配置pom.xml文件，导入依赖的坐标

建立applicationConfig.xml文件，作为spring的配置文件，整合spring和mybatis

配置文件中使用<component-scan>标签配置注解扫描，扫描service 和dao包
使用v2.c3p0配置连接池，此处需要一个数据库的配置文件jdbcConfig.properties
整合mybatis,配置sqlSessionFactoryBean
配置PageHelper插件
配置声明式事务
使用MapperScannerConfigurer配置扫描dao接口
编写springmvc.xml

配置扫描包的规则，只扫描controller包
配置视图解析器，指定jsp文件的位置和后缀名
配置静态资源不过滤
使用mvc:annotation-driven配置注解支持
使用aop:aspect-autoproxy配置AOP注解支持
编写springsecurity.xml文件

配置具体的拦截规则，拦截路径，访问系统需要具备的权限
定义具体的跳转页面
配置注销用户的跳转
配置加密方式
编写具体的service dao controller和domain

在需要使用分页的地方配置

List<Orders> ordersList = ordersService.findAll(page, size);
PageInfo pageInfo = new PageInfo(ordersList);
在页面权限控制的地方使用注解

<security:authorize access="hasRole('ADMIN')">

表示该内容对拥有ADMIN权限的用户可见

在服务器上使用注解限制用户对方法的访问

@Secured("ROLE_ADMIN")
表示拥有ADMIN权限的用户才可以访问该方法

数据库的多表查询以及定义返回结果
