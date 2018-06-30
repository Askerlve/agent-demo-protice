package com.askerlve.dubbo.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProviderApp {

    // 启动时请添加JVM参数:
    // Dubbo协议的端口: -Ddubbo.protocol.port=20889
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class,args);
    }
}
