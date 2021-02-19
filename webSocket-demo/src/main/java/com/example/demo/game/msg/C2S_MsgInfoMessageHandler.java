package com.example.demo.game.msg;

import com.example.demo.C2S_MessageScript;
import com.example.demo.game.button.ButtonInfo;
import com.example.demo.game.initGame.C2S_InitGameMessageHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;


//// 代表可以被多个channel线程安全共享
//@ChannelHandler.Sharable
@Log4j2
@Component
//public class C2S_MsgInfoMessageHandler extends SimpleChannelInboundHandler<msgInfo.Login> implements C2S_Message {
public class C2S_MsgInfoMessageHandler extends C2S_MessageScript {
//    @Autowired
//    private TaskExecutor taskExecutor;
//    /**
//     * 负责客户端Channel管理(线程安全)
//     */
//    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, msgInfo.Login login) throws Exception {
//        System.out.println(login.getName());
//        System.out.println("MSGInfoMes");
//
//
//    }

    private final static Logger logger = LoggerFactory.getLogger(C2S_MsgInfoMessageHandler.class);
    private volatile static C2S_MsgInfoMessageHandler initGameMessage;

    public static C2S_MsgInfoMessageHandler getMe(){
        if (initGameMessage == null){
            synchronized (C2S_MsgInfoMessageHandler.class){
                if (initGameMessage == null){
                    initGameMessage = new C2S_MsgInfoMessageHandler();
                }
            }
        }
        return initGameMessage;
    }
    @Override
    public void action() {
        System.out.println("msg");
    }
}
