package com.askerlve.dubbo.demo.agent.dubbo;

import com.askerlve.dubbo.demo.agent.model.Request;
import com.askerlve.dubbo.demo.agent.model.RpcFuture;
import com.askerlve.dubbo.demo.agent.model.RpcInvocation;
import com.askerlve.dubbo.demo.agent.model.RpcRequestHolder;
import com.askerlve.dubbo.demo.agent.utils.JsonUtils;
import io.netty.channel.Channel;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class RpcClient {

    private ConnectManager connectManager;

    public RpcClient(){
        this.connectManager = new ConnectManager();
    }

    public Object hello(String name) throws Exception {

        Channel channel = connectManager.getChannel("");

        RpcInvocation invocation = new RpcInvocation();
        invocation.setMethodName("hello");
        invocation.setAttachment("path", "com.askerlve.dubbo.demo.provider.IHelloService");
        invocation.setParameterTypes("Ljava/lang/String;");// 这块用ReflecUtils转换成字符串

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
        JsonUtils.writeObject(name, writer);
        invocation.setArguments(out.toByteArray());

        Request request = new Request();
        request.setVersion("2.0.0");
        request.setTwoWay(true);
        request.setData(invocation);

        System.out.println("requestId=" + request.getId());

        RpcFuture future = new RpcFuture();
        RpcRequestHolder.put(String.valueOf(request.getId()),future);

        channel.writeAndFlush(request);

        Object result = null;
        try {
            result = future.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        // result是byte數組，可能準不了
        return result;
    }
}
