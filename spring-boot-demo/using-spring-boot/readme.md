## 禁用自动配置类
```java
// 假如你引入了datasource 的东西,但是暂时不想配置数据库可以这样使用, 排除自动配置的 Datasource
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MyApplication {
}
```