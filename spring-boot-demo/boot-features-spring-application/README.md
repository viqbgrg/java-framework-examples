### 自定义横幅

添加 banner.txt 文件 可实现自定义横幅

### 自定义SpringApplication

```java
public static void main(String[] args) {
    SpringApplication app = new SpringApplication(MySpringConfiguration.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
}
```

### Fluent Builder API

#### 什么层次结构

todo

### 1.9 访问应用程序参数

ApplicationArguments 可以获取一些应用程序的参数信息

## 单元测试

```java
// 在测试的时候, 可能会写多个主的springbootapplication 类 可以通过 classes 指定 spring boot 的 application
@SpringBootTest(classes = MyApplication.class)
```
