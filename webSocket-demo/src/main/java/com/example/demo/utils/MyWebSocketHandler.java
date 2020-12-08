package com.example.demo.utils;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.msgInfo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！");

        //添加到channelGroup通道组
        MyChannelHandlerPool.channelGroup.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端断开连接，通道关闭！");
        //添加到channelGroup 通道组
        MyChannelHandlerPool.channelGroup.remove(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //首次连接是FullHttpRequest，处理参数 by zhengkai.blog.csdn.net
        if (null != msg && msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            String uri = request.uri();
            Map paramMap=getUrlParams(uri);
            System.out.println("接收到的参数是："+ JSONObject.toJSONString(paramMap));
            //如果url包含参数，需要处理
            if(uri.contains("?")){
                String newUri=uri.substring(0,uri.indexOf("?"));
                System.out.println(newUri);
                request.setUri(newUri);
            }
            msgInfo.Login.Builder loginMsgInfo = msgInfo.Login.newBuilder();
            loginMsgInfo.setName("yxy");
            loginMsgInfo.setPwd("test1");
//            MyChannelHandlerPool.channelGroup.writeAndFlush(loginMsgInfo);

        }else if(msg instanceof TextWebSocketFrame){
            //正常的TEXT消息类型
            TextWebSocketFrame frame=(TextWebSocketFrame)msg;
            System.out.println("客户端收到服务器数据：" +frame.text());
            sendAllMessage(frame.text());
            msgInfo.Login.Builder loginMsgInfo = msgInfo.Login.newBuilder();
            loginMsgInfo.setName("yxy");
            loginMsgInfo.setPwd("test1");
//            channelRead(frame.content(),ctx);

//            MyChannelHandlerPool.channelGroup.writeAndFlush(loginMsgInfo);
        }else{
            WebSocketFrame frame = (WebSocketFrame) msg;
            ByteBuf buf = (ByteBuf)frame.content();
            byte[] barray = new byte[buf.readableBytes()];
//把数据从bytebuf转移到byte[]
            buf.getBytes(0,barray);
            // 接收到流并读取
//            ByteArrayInputStream input = new ByteArrayInputStream(barray);
            // 反序列化
            msgInfo.Login userInfo1 = msgInfo.Login.parseFrom(barray);
            System.out.println(userInfo1);
            buf.retain();
            sendAllMessageTwo(buf);
        }
        super.channelRead(ctx, msg);
    }

//    public void channelRead1(Object msg,ChannelHandlerContext ctx){
//        try {
//            ByteBuf buf = (ByteBuf)msg;
////创建目标大小的数组
//            byte[] barray = new byte[buf.readableBytes()];
////把数据从bytebuf转移到byte[]
//            buf.getBytes(0,barray);
//            //将byte[]转成字符串用于打印
//            String str=new String(barray);
//
//            if (str.length()>0)
//            {
//                System.out.println(str);
//                System.out.flush();
//            }
//            else
//            {
//                System.out.println("不能读啊");
//            }
//            buf.release();
//        }finally {
////buf.release();
//        }
//    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
        cause.printStackTrace();
        ctx.close();

    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {

    }

    private void sendAllMessage(String message){
        //收到信息后，群发给所有channel
        MyChannelHandlerPool.channelGroup.writeAndFlush( new TextWebSocketFrame(message));
    }
    private void sendAllMessageTwo(ByteBuf message){
        //收到信息后，群发给所有channel

        MyChannelHandlerPool.channelGroup.writeAndFlush(new BinaryWebSocketFrame(message));
    }

    private static Map getUrlParams(String url){
        Map<String,String> map = new HashMap<>();
        url = url.replace("?",";");
        url = url.replace("^&","&");
        if (!url.contains(";")){
            return map;
        }
        if (url.split(";").length > 0){
            String[] arr = url.split(";")[1].split("&");
            for (String s : arr){
                String key = s.split("=")[0];
                String value = s.split("=")[1];
                map.put(key,value);
            }
            return  map;

        }else{
            return map;
        }
    }
}