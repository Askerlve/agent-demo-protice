package com.askerlve.dubbo.demo.provider;


public class HelloServiceMock implements IHelloService {
    @Override
    public String hello() {
        return "Mock";
    }

    @Override
    public String hello(String name) {
        return "Mock " + name;
    }
}
