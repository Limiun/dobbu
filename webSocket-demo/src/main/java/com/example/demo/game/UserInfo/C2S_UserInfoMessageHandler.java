package com.example.demo.game.UserInfo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class C2S_UserInfoMessageHandler extends SimpleChannelInboundHandler<UserInfo.UserMsg> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, UserInfo.UserMsg userMsg) throws Exception {
        System.out.println("UserInfo+++++++++++++++++++"+userMsg.getAge());
        System.out.println("UserInfo+++++++++++++++++++"+userMsg.getName());
        System.out.println("UserInfo+++++++++++++++++++"+userMsg.getId());
    }
}
