package com.example.demo.game.role_test1;

import com.example.demo.Cache.SaveCache;
import com.example.demo.MessageType;
import com.example.demo.bean.test;
import com.example.demo.game.UserInfo.C2S_UserInfoMessageHandler;
import com.example.demo.game.button.C2S_ButtonTestMessageHandler;
import com.example.demo.game.msg.C2S_MsgInfoMessageHandler;
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
import java.util.List;

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
        List<test> testList = (List<test>) SaveCache.getMe().getCacheItem("test");
        int msgType = message.getMsgBodyCase().getNumber()-1;
       // Test1.Message.MsgType msgType = message.getMsgType();
        if (msgType == Test1.Message.MsgType.TEST1.getNumber()){

//           c2S_buttonTestMessageHandler.channelRead0(channelHandlerContext,);
        }else if (msgType == Test1.Message.MsgType.GAME.getNumber()){
            System.out.println("GAME");
            Test1.Test1Msg test1Msg = builder.build();
//            byte[] b= test1Msg.toByteArray();
//            ByteBuf buf =  Unpooled.wrappedBuffer(b);
            //webSocket.sendAllMessageByteBuf(buf);
            //webSocket.sendMessageByMes(test1Msg, MessageType.test1Msg.getMsgId());
            webSocket.sendMessageByPlayerWeb(channelHandlerContext,test1Msg, MessageType.test1Msg.getMsgId());
        }
    }
}
