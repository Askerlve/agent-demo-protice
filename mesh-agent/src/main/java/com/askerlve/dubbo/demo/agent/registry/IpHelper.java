package com.askerlve.dubbo.demo.agent.registry;

import java.net.InetAddress;

/**
 * @author Askerlve
 * @Description: IpHelper
 * @date 2018/6/26下午6:00
 */
public class IpHelper {

    public static String getHostIp() throws Exception {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return ip;
    }

}
