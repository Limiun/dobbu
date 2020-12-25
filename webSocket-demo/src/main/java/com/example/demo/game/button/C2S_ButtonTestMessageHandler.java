package com.example.demo.game.button;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;


// 代表可以被多个channel线程安全共享
@ChannelHandler.Sharable
@Log4j2
@Component
public class C2S_ButtonTestMessageHandler  extends SimpleChannelInboundHandler<ButtonInfo.UserMsg> {

    @Autowired
    private TaskExecutor taskExecutor;
    /**
     * 负责客户端Channel管理(线程安全)
     */
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ButtonInfo.UserMsg userMsg) throws Exception {
        System.out.println("testbuttom");
        userMsg.getId();

    }

    /**
     * 接收处理客户端发送数据
     * @param channelHandlerContext
     * @param stockMessage
     * @throws Exception
     */
//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ButtonInfo.UserMsg stockMessage) throws Exception {
//        // 异步处理
//        taskExecutor.execute(() -> {
//            try {
//                // 异步线程处理业务逻辑
//
//            } catch (Exception e) {
//
//            }
//        }
//    }

}
