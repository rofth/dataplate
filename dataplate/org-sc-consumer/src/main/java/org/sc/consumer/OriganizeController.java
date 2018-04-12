package org.sc.consumer;

import org.sc.consumer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OriganizeController {


    @Autowired
    HelloRemote helloRemote;


    @RequestMapping("/indexOrganizaList/{name}")
    public String indexOrganizaList(@PathVariable("name") String name){
        return helloRemote.indexOrganizaList(name);
    }
}
