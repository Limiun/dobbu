package com.example.demo.utils;


import com.example.demo.game.UserInfo.C2S_UserInfoMessageHandler;
import com.example.demo.game.UserInfo.UserInfo;
import com.example.demo.game.button.ButtonInfo;
import com.example.demo.game.button.C2S_ButtonTestMessageHandler;
import com.example.demo.game.msg.C2S_MsgInfoMessageHandler;
import com.example.demo.game.msg.msgInfo;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static io.netty.buffer.Unpooled.wrappedBuffer;


/**
 * NettyServer Netty服务器配置
 * @author zhengkai.blog.csdn.net
 * @date 2019-06-12
 */
/**
 * NettyServer Netty服务器配置
 * @author zhengkai.blog.csdn.net
 * @date 2019-06-12
 */
public class NettyServer {

    private static final Logger log = LoggerFactory.getLogger(NettyServer.class);
    private final int port;

    @Autowired
    private C2S_ButtonTestMessageHandler c2s_buttonTestMessageHandler;
    @Autowired
    private C2S_MsgInfoMessageHandler c2s_msgInfoMessageHandler;
    @Autowired
    private C2S_UserInfoMessageHandler c2s_userInfoMessageHandler;


    public NettyServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap sb = new ServerBootstrap();
            sb.option(ChannelOption.SO_BACKLOG, 1024);
            sb.group(group, bossGroup) // 绑定线程池
                    .channel(NioServerSocketChannel.class) // 指定使用的channel
                    .localAddress(this.port)// 绑定监听端口
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("收到新连接");
                            //websocket协议本身是基于http协议的，所以这边也要使用http解编码器
                            ch.pipeline().addLast(new HttpServerCodec());
                            //以块的方式来写的处理器  支持大数据流写入
                            ch.pipeline().addLast(new ChunkedWriteHandler());
                            // 支持参数对象解析， 比如POST参数， 设置聚合内容的最大长度
                            ch.pipeline().addLast(new HttpObjectAggregator(65536));
                            ch.pipeline().addLast(new MyWebSocketHandler());

//                            ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws", "WebSocket", true, 65536 * 10));
                            ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws", null, true));

                            //解码器，通过Google Protocol Buffers序列化框架动态的切割接收到的ByteBuf
                            ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                            //Google Protocol Buffers 长度属性编码器
                            ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());


                            // 协议包解码
                            ch.pipeline().addLast(new MessageToMessageDecoder<WebSocketFrame>() {
                                @Override
                                protected void decode(ChannelHandlerContext ctx, WebSocketFrame frame, List<Object> objs) throws Exception {
                                    log.info("received client msg ------------------------");
                                    if (frame instanceof TextWebSocketFrame) {
                                        // 文本消息
                                        TextWebSocketFrame textFrame = (TextWebSocketFrame)frame;
                                        log.info("MsgType is TextWebSocketFrame");
                                    } else if (frame instanceof BinaryWebSocketFrame) {
                                        // 二进制消息
                                        ByteBuf buf = ((BinaryWebSocketFrame) frame).content();
                                        objs.add(buf);
                                        // 自旋累加
                                        buf.retain();
                                        log.info("MsgType is BinaryWebSocketFrame");
                                    } else if (frame instanceof PongWebSocketFrame) {
                                        // PING存活检测消息
                                        log.info("MsgType is PongWebSocketFrame ");
                                    } else if (frame instanceof CloseWebSocketFrame) {
                                        // 关闭指令消息
                                        log.info("MsgType is CloseWebSocketFrame");
                                        ch.close();
                                    }

                                }
                            });
                            // 协议包编码
                            ch.pipeline().addLast(new MessageToMessageEncoder<MessageLiteOrBuilder>() {
                                @Override
                                protected void encode(ChannelHandlerContext ctx, MessageLiteOrBuilder msg, List<Object> out) throws Exception {
                                    ByteBuf result = null;
                                    if (msg instanceof MessageLite) {
                                        // 没有build的Protobuf消息
                                        result = wrappedBuffer(((MessageLite) msg).toByteArray());
                                    }
                                    if (msg instanceof MessageLite.Builder) {
                                        // 经过build的Protobuf消息
                                        result = wrappedBuffer(((MessageLite.Builder) msg).build().toByteArray());
                                    }
                                    // 将Protbuf消息包装成Binary Frame 消息
                                    WebSocketFrame frame = new BinaryWebSocketFrame(result);
                                    out.add(frame);
                                }
                            });

                            // Protobuf消息解码器
                            ch.pipeline().addLast(new ProtobufDecoder(ButtonInfo.UserMsg.getDefaultInstance()));
                            // Protobuf消息解码器
                            ch.pipeline().addLast(new ProtobufDecoder(msgInfo.Login.getDefaultInstance()));
                            ch.pipeline().addLast(new ProtobufDecoder(UserInfo.UserMsg.getDefaultInstance()));

                            // 自定义数据处理器
                            ch.pipeline().addLast(c2s_buttonTestMessageHandler);
                            // 自定义数据处理器
                            ch.pipeline().addLast(c2s_msgInfoMessageHandler);
                            ch.pipeline().addLast("C2S_UserInfoMessageHandler",c2s_userInfoMessageHandler);
                        }
                    });


            ChannelFuture cf = sb.bind().sync(); // 服务器异步创建绑定
            System.out.println(NettyServer.class + " 启动正在监听： " + cf.channel().localAddress());
            cf.channel().closeFuture().sync(); // 关闭服务器通道
        } finally {
            group.shutdownGracefully().sync(); // 释放线程池资源
            bossGroup.shutdownGracefully().sync();
        }
    }
}