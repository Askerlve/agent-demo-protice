package com.askerlve.dubbo.demo.agent.dubbo;

import com.askerlve.dubbo.demo.agent.model.Request;
import com.askerlve.dubbo.demo.agent.model.RpcResponse;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("logging", new LoggingHandler(LogLevel.INFO));
        pipeline.addLast(new DubboRpcEncoder(Request.class));
        pipeline.addLast(new DubboRpcDecoder(RpcResponse.class));
        pipeline.addLast(new RpcClientHandler());
    }
}
