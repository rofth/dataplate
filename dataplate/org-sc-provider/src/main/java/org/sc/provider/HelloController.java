package org.sc.provider;

import com.alibaba.fastjson.JSON;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*** 自动注入Config对象 ***/
    @ApolloConfig("application")
    private Config config;

    @Value("${dev-dataPlate-version:default_001}") // 如果配置中心没有值，则默认为default_001
    private String dev_dataPlate_version;

    @Autowired
    private Global global;

    @Autowired
    private UserService userService;

    /***
     * 提供hello服务
     * @param name
     * @return
     */
    @RequestMapping("/hello")
    public String indexList(@RequestParam String name){
        System.out.printf("---------------------------------------------------------------------------");
        return JSON.toJSONString(userService.getUserList());
    }

    /***
     * 监听Apollo 属性变化
     * @param changeEvent
     */
    @ApolloConfigChangeListener("application")
    public void anotherOnChange(ConfigChangeEvent changeEvent){
        /** 批量设置 **/
        for(String key : changeEvent.changedKeys()){
            ConfigChange change = changeEvent.getChange(key);
            System.out.printf(change.getNewValue());
        }
    }
}
