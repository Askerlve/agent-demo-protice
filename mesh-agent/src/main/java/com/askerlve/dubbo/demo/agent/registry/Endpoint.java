package com.askerlve.dubbo.demo.agent.registry;

/**
 * @author Askerlve
 * @Description: Endpoint
 * @date 2018/6/26下午5:59
 */
public class Endpoint {

    private final String host;
    private final int port;

    public Endpoint(String host,int port){
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String toString(){
        return host + ":" + port;
    }

    public boolean equals(Object o){
        if (!(o instanceof Endpoint)){
            return false;
        }
        Endpoint other = (Endpoint) o;
        return other.host.equals(this.host) && other.port == this.port;
    }

    public int hashCode(){
        return host.hashCode() + port;
    }

}
