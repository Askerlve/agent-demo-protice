package com.askerlve.dubbo.demo.agent.dubbo;

import com.askerlve.dubbo.demo.agent.registry.Endpoint;
import com.askerlve.dubbo.demo.agent.registry.IRegistry;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.List;
import java.util.Random;

public class ConnectManager {
    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup(4);

    private Bootstrap bootstrap;

    public ConnectManager(){
    }

    public Channel getChannel() throws Exception {
        if ( null == bootstrap){
            initBootstrap();
        }

        Channel channel = bootstrap.connect("127.0.0.1", 20889).sync().channel();

        return channel;
    }

    public void initBootstrap() {

        bootstrap = new Bootstrap()
                .group(eventLoopGroup)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator.DEFAULT)
                .channel(NioSocketChannel.class)
                .handler(new RpcClientInitializer());
    }
}
