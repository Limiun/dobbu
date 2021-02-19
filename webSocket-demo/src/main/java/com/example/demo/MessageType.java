package com.example.demo;
import com.example.demo.game.initGame.C2S_InitGameMessageHandler;
import com.example.demo.game.msg.C2S_MsgInfoMessageHandler;
import com.example.demo.game.role_test1.Test1.Message.*;

import com.example.demo.game.role_test1.Test1;

public enum MessageType {
    Messgae(1,"最外层消息",MsgType.UNIVERSAL, C2S_InitGameMessageHandler.getMe()),
    test1Msg(2,"测试1",MsgType.TEST1, C2S_InitGameMessageHandler.getMe()),
    game(3,"测试2游戏",MsgType.GAME, C2S_MsgInfoMessageHandler.getMe())
    ;
    private int msgId;

    private String value;

    private  MsgType msgType;

    private C2S_MessageScript messageScript;
    MessageType(int msgId, String value, MsgType msgType,C2S_MessageScript messageScript) {
        this.msgId = msgId;
        this.value = value;
        this.msgType = msgType;
        this.messageScript = messageScript;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Test1.Message.MsgType getMsgType() {
        return msgType;
    }

    public C2S_MessageScript getMessageScript() {
        return messageScript;
    }

    public void setMessageScript(C2S_MessageScript messageScript) {
        this.messageScript = messageScript;
    }

    public void setMsgType(Test1.Message.MsgType msgType) {
        this.msgType = msgType;
    }

    public static MessageType getMessageIdByMesId(int msgId){
        for (MessageType messageType:values()){
            if (msgId==messageType.getMsgId()){
                return messageType;
            }
        }
        return null;
    }
    public static C2S_MessageScript getC2sMessageHandler(int msgId){
        for (MessageType messageType:values()){
            if (msgId==messageType.getMsgId()){
                return messageType.messageScript;
            }
        }
        return null;
    }

}
