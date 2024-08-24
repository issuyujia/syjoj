package com.syj.syjojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@MapperScan("com.syj.syjojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.syj")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.syj.syjojbackendserviceclient.service"})
public class SyjojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyjojBackendUserServiceApplication.class, args);
    }

}
