package com.example.demo.game.UserInfo;

import com.example.demo.utils.MyChannelHandlerPool;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

@Component
public class C2S_UserInfoMessageHandler extends SimpleChannelInboundHandler<UserInfo.UserMsg> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！");
        //添加到channelGroup通道组
        MyChannelHandlerPool.channelGroup.add(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, UserInfo.UserMsg userMsg) throws Exception {
        System.out.println("UserInfo+++++++++++++++++++"+userMsg.getAge());
        System.out.println("UserInfo+++++++++++++++++++"+userMsg.getName());
        System.out.println("UserInfo+++++++++++++++++++"+userMsg.getId());
    }
}
