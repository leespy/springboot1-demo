目的：配置

【Spring Boot基本配置】
1>入口类
    1.1>Spring Boot通常有一个名为*Application的入口类，入口类里有一个main方法，这个就是标准的Java应用的入口方法。
    1.2>在main方法中使用SpringApplication.run，启动Spring Boot应用项目
    1.3>@SpringBootApplication是Spring Boot的核心注解，它是一个组合注解。
    1.4>@EnableAutoConfiguration让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置。
    1.5>Spring Boot会自动扫描@SpringBootApplication所在类的同级包以及下级包里的Bean。建议入口类放置的位置在groupId+arctifaceId组合的包名下。

    【SpringBootApplication.java】
        @Target(ElementType.TYPE)
        @Retention(RetentionPolicy.RUNTIME)
        @Documented
        @Inherited
        @SpringBootConfiguration
        @EnableAutoConfiguration
        @ComponentScan(excludeFilters = {
		        @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		        @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
        public @interface SpringBootApplication {

	        @AliasFor(annotation = EnableAutoConfiguration.class, attribute = "exclude")
	        Class<?>[] exclude() default {};

	        @AliasFor(annotation = EnableAutoConfiguration.class, attribute = "excludeName")
	        String[] excludeName() default {};

	        @AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
	        String[] scanBasePackages() default {};

	        @AliasFor(annotation = ComponentScan.class, attribute = "basePackageClasses")
	        Class<?>[] scanBasePackageClasses() default {};
        }

2>关闭特定的自动配置
    通过上面@SpringBootApplication的源码我们可以看出，关闭特定的自动配置应该使用@SpringBootApplication注解的exclude参数，如下所示：
    @SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

3>定制Banner
    3.1>在src/main/resources下新建一个banner.txt即可。
    3.2>关闭Banner
        SpringApplication app = new SpringApplication(Springboot1DemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

4>Spring Boot的配置文件
    src/main/resources/application.properties
    或
    src/main/resources/application.yml

5>starter pom
    5.1>官方starter pom
        spring-boot-starter                     | Spring Boot核心starter，包含自动配置、日志、yaml配置文件的支持。
        spring-boot-starter-actuator            | 准生成特性，用来监控和管理应用
        spring-boot-starter-remote-shell        | 提供基于ssh协议的监控和管理
        spring-boot-starter-amqp                | 使用spring-rabbit来支持AMQP
        spring-boot-starter-aop                 | 使用spring-aop和AspectJ支持面向切面编程
        spring-boot-starter-batch               | 对Spring Batch的支持
        spring-boot-starter-cache               | 对Spring Cache抽象的支持
        spring-boot-starter-cloud-connectors    | 对云平台（Cloud Foundry、Heroku）提供的服务提供简化的连接方式
        spring-boot-starter-data-elasticsearch  | 通过spring-data-elasticsearch对Elasticsearch支持
        spring-boot-starter-data-gemfire        | 通过spring-data-gemfire对分布式存储GemFire的支持
        spring-boot-starter-data-jpa            | 对JPA的支持，包含spring-data-jpa、spring-orm和Hibernate
        spring-boot-starter-data-mongodb        | 对MongoDB进行支持
        spring-boot-starter-data-rest           | 通过spring-data-rest-webmvc将Spring Data repository暴露为REST形式的服务
        spring-boot-starter-data-solr           | 对Apache Solr数据检索平台的支持
        spring-boot-starter-freemarker          | 对FreeMarker模板引擎的支持
        spring-boot-starter-groovy-templates    | 对Groovy模板引擎的支持
        spring-boot-starter-hateoas             | 对基于HATEOAS的REST形式的网络服务的支持
        spring-boot-starter-hornetq             | 通过HornetQ对JMS的支持
        spring-boot-starter-integration         | 对系统继承框架spring-integration的支持
        spring-boot-starter-jdbc                | 对JDBC数据库的支持
        spring-boot-starter-jersey              | 对Jersery REST形式的网络服务的支持
        spring-boot-starter-jta-atomikos        | 通过Atomikos对分布式事务的支持
        spring-boot-starter-jta-bitronix        | 通过Bitronix对分布式事务的支持
        spring-boot-starter-mail                | 对javax.mail的支持
        spring-boot-starter-mobile              | 对spring-mobile的支持
        spring-boot-starter-mustache            | 对Mustache模板引擎的支持
        spring-boot-starter-redis               | 对Redis的支持
        spring-boot-starter-security            | 对pring-security的支持
        spring-boot-starter-social-facebook     | 对Facebook的支持
        spring-boot-starter-social-linkedin     | 对Linkedin的支持
        spring-boot-starter-social-twitter      | 对Twitter的支持
        spring-boot-starter-test                | 对常用的测试框架JUnit、Hamcrest和Mockito的支持，包含spring-test模块
        spring-boot-starter-thymeleaf           | 对Thymeleaf模板引擎的支持，包含于Spring整合的配置
        spring-boot-starter-velocity            | 对Velocity模板引擎的支持
        spring-boot-starter-web                 | 对Web项目开发的支持，包含Tomcat和spring-webmvc
        spring-boot-starter-Tomcat              | Spring Boot默认的Servlet容器Tomcat
        spring-boot-starter-Jetty               | 使用Jetty作为Servlet容器替换Tomcat
        spring-boot-starter-undertow            | 使用Undertow作为Servlet容器替换Tomcat
        spring-boot-starter-logging             | Spring Boot默认的日志框架Logback
        spring-boot-starter-log4j               | 支持使用Log4J日志框架
        spring-boot-starter-websocket           | 对WebSocket开发的支持
        spring-boot-starter-ws                  | 对Spring Web Services的支持
    5.2>第三方starter pom
        Handlebars              |   handlebars-spring-boot-starter
        Vaadin                  |   vaadin-spring-boot-starter
        Apache Camel            |   camel-spring-boot
        WRO4j                   |   spring-boot-autoconfigure-wro4j
        Spring Batch (Jade4J)   |   spring-boot-starter-batch-web
        HDIV                    |   spring-boot-starter-hdiv
        Jade Templates (Jade4J) |   spring-boot-starter-jade4j
        Activiti                |   activiti-spring-boot/spring-boot-starters

6>使用xml配置
    @ImportResource({"classpath:some-context.xml","classpath:another-context.xml"}) 引入xml配置
    public class Springboot1DemoApplication {
        ... ...
    }

【Spring Boot外部配置】
1>命令行参数配置
    java -jar xx.jar --server.port=9090

2>常规属性配置
    在Spring Boot里，我们只需在application.properties定义属性，直接使用@Value注入即可。
    eg：Demo1Application.java

3>基于properties的类型安全的配置
    通过@ConfigurationProperties将properties属性和一个Bean及其属性关联，从而简化使用@Value的方式获取属性。
    eg：Demo2Application.java
    指定加载的配置文件（如果与默认配置文件application.properties中存在相同属性，则会以默认配置文件中的属性为准）
    eg：Demo3Application.java