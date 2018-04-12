import org.sc.consumer.zuulFilter.ZuulAccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/***
 *  组织架构启动
 *  EnableDiscoveryClient : 启用服务注册与发现
 *  EnableFeignClients ： 启用feign进行远程调用
 *  feign ：声明式Web Service 客户端，可以与Eureka和Ribbon组合使用以支持负载均衡
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients
@ComponentScan(basePackages = {"org.sc.consumer"})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    public ZuulAccessFilter zuulAccessFilter(){
        return new ZuulAccessFilter();
    }

}
