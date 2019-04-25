package com.sq.idsvr.endpoint;

import com.sq.idsvr.servie.IdService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sq
 * @version 1.0
 * @className IdEndpoint
 * @description id接口
 * @date 2019/4/24 上午11:36
 */
@RestController
public class IdEndpoint {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    IdService idService;

    @RequestMapping("/id/next")
    public Long nextId(){
        return idService.nextId();
    }
}
