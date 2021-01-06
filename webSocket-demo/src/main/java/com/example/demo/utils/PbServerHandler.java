package com.example.demo.utils;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;


public class PbServerHandler extends SimpleChannelHandler {

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        e.getChannel().write("连接成功");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
            throws Exception {
//        Test1.Request request = (Test1.Request) e.getMessage();
//        System.out.println("cmd:" + request.getUid());
//        Test1.test1Msg test1Msg1 = (Test1.test1Msg) e.getMessage();
//        System.out.println("user:" + test1Msg1.getName());
//        System.out.println("psw:" + test1Msg1.getId());
    }
}