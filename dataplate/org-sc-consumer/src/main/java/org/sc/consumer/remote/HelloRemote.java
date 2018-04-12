package org.sc.consumer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 *   feign 调用实现
 *   name ： 远程服务名，即 application.properties中配置的名称
 *   此类中的方法和远程服务中的controller中的方法名和参数需保持一致
 */
@FeignClient(name = "lyplate-userServer-1")
public interface HelloRemote {

    /***
     * value ： 提供远程服务的controller的名称
     * @param name : 远程服务的参数
     */
    @RequestMapping(value = "/hello")
    String indexOrganizaList(@RequestParam(value = "name") String name);
}
