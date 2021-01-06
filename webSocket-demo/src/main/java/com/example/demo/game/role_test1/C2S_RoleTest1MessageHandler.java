package com.example.demo.game.role_test1;

import com.example.demo.utils.MyChannelHandlerPool;
import com.example.demo.utils.MyWebSocketHandler;
import com.example.demo.utils.NettyServer;
import com.example.demo.utils.WebSocket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.Buffer;
import java.nio.ByteBuffer;

@Component
public class C2S_RoleTest1MessageHandler extends SimpleChannelInboundHandler<Test1.Message> {

    MyWebSocketHandler webSocket = new MyWebSocketHandler();

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
        Test1.Test1Msg.Builder builder = Test1.Test1Msg.newBuilder();
        builder.setId(125);
        builder.setAge(23);
        builder.setName("zxk");
        builder.setState(0);
        int msgType = message.getMsgBodyCase().getNumber()-1;
       // Test1.Message.MsgType msgType = message.getMsgType();
        if (msgType == Test1.Message.MsgType.TEST1.getNumber()){
            System.out.println("TEST1");
            webSocket.sendAllMessage("sdfsf");
        }else if (msgType == Test1.Message.MsgType.GAME.getNumber()){
            System.out.println("GAME");
            Test1.Test1Msg test1Msg = builder.build();
            byte[] b= test1Msg.toByteArray();
            ByteBuf buf =  Unpooled.wrappedBuffer(b);
            webSocket.sendAllMessageByteBuf(buf);
        }
    }
}
