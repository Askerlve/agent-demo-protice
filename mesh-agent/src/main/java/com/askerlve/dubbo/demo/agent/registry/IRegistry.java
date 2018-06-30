package com.askerlve.dubbo.demo.agent.registry;

import java.util.List;

/**
 * @author Askerlve
 * @Description: IRegistry
 * @date 2018/6/26下午6:00
 */
public interface IRegistry {

    // 注册服务
    void register(String serviceName, int port) throws Exception;

    List<Endpoint> find(String serviceName) throws Exception;

}
