package com.example.demo.game.msg;

import com.example.demo.game.button.ButtonInfo;
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

@Component
// 代表可以被多个channel线程安全共享
@ChannelHandler.Sharable
@Log4j2
public class C2S_MsgInfoMessageHandler extends SimpleChannelInboundHandler<msgInfo.Login> {
    @Autowired
    private TaskExecutor taskExecutor;
    /**
     * 负责客户端Channel管理(线程安全)
     */
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, msgInfo.Login login) throws Exception {
        System.out.println(login.getName());
        System.out.println("c2s");

    }
}
