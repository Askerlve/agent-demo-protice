package com.askerlve.dubbo.demo.provider;

import org.springframework.context.annotation.ImportResource;

@org.springframework.context.annotation.Configuration
@ImportResource(locations={"classpath*:dubbo-provider.xml"})
public class Configuration {
}
