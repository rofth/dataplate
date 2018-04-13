import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/***
 * Springboot启动的时候，默认是扫描当前类所在包的对象，如果，当前包没有对象，则会抛出错误：
 *           Your ApplicationContext is unlikely to start due to a @ComponentScan of the default package
 *           因为启动类不能直接放在main/java文件夹下，必须要建立一个包把它放进去或者使用@ComponentScan指明要扫描的包
 * 激活eureka中的DiscoveryClient实现
 *
 * application : 为该AppId在配置中心的默认私有命名空间，里面存放该Appid自由的配置属性，默认自带的命名空间。但是若指定了其它命名空间，application也需要
 *               写上
 * DEPT1.eureka.client.serviceUrl，为注册中心地址，公共属性
 * DEPT1.hikari.HikariDataSource，为数据库连接池地址，公共属性
 */
@EnableDiscoveryClient
@SpringBootApplication
//@EnableApolloConfig({"application","DEPT1.rureka.client.serverUrl","DEPT1.hikari.HikariDataSource"})
@ComponentScan(basePackages = {"org.sc.**"}) // 扫描org.sc下所有的包
@MapperScan("org.sc.mapper.dao")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
        System.out.printf("---");
        System.out.printf("--->>>");
    }
}
