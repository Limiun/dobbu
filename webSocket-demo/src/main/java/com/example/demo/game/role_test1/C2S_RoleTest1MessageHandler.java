package com.example.demo.game.role_test1;

import com.example.demo.utils.MyChannelHandlerPool;
import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

@Component
public class C2S_RoleTest1MessageHandler extends SimpleChannelInboundHandler<Test1.Message> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！...");
        //添加到channelGroup通道
        MyChannelHandlerPool.channelGroup.add(ctx.channel());
    }
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Test1.Message message) throws Exception {
        System.out.println("ROLEtest1Msg经接受成功&&&&&&&&&&&&&&&&&&&");
        System.out.println("msgType:"+message.getMsgType());
        int msgType = message.getMsgBodyCase().getNumber()-1;
       // Test1.Message.MsgType msgType = message.getMsgType();
        if (msgType == Test1.Message.MsgType.TEST1.getNumber()){
            System.out.println("TEST1");
        }else if (msgType == Test1.Message.MsgType.GAME.getNumber()){
            System.out.println("GAME");
        }
    }
}
