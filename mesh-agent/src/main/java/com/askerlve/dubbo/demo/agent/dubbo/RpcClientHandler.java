package com.askerlve.dubbo.demo.agent.dubbo;

import com.askerlve.dubbo.demo.agent.model.RpcFuture;
import com.askerlve.dubbo.demo.agent.model.RpcRequestHolder;
import com.askerlve.dubbo.demo.agent.model.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RpcClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponse response) throws Exception {
        String requestId = response.getRequestId();
        RpcFuture future = RpcRequestHolder.get(requestId);
        if(null != future){
            RpcRequestHolder.remove(requestId);
            future.done(response);
        }
    }
}
