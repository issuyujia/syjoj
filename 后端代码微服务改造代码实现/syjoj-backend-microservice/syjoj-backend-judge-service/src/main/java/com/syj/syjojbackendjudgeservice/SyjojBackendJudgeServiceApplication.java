package com.syj.syjojbackendjudgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *@author syj
 *@date 2024/8/18 17:39
*/
@SpringBootApplication()
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.syj")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.syj.syjojbackendserviceclient.service"})
public class SyjojBackendJudgeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SyjojBackendJudgeServiceApplication.class, args);
    }

}
