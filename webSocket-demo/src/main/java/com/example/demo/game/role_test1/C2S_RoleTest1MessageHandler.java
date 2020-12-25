package com.example.demo.game.role_test1;



import com.example.demo.game.role_test1.Test1;
import com.example.demo.utils.MyChannelHandlerPool;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

@Component
public class C2S_RoleTest1MessageHandler extends SimpleChannelInboundHandler<Test1.test1Msg> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！...");
        //添加到channelGroup通道组
        MyChannelHandlerPool.channelGroup.add(ctx.channel());
    }
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Test1.test1Msg test1Msg) throws Exception {
        System.out.println("test1Msg经接受成功&&&&&&&&&&&&&&&&&&&");
        System.out.println(test1Msg.getName());
    }
}
