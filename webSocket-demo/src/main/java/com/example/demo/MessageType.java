package com.example.demo;
import com.example.demo.game.role_test1.Test1.Message.*;

import com.example.demo.game.role_test1.Test1;

public enum MessageType {
    Messgae(1,"最外层消息",MsgType.UNIVERSAL),
    test1Msg(2,"测试1",MsgType.TEST1),
    game(3,"测试2游戏",MsgType.GAME)
    ;
    private int msgId;
    private String value;
    private  MsgType msgType;
    MessageType(int msgId, String value, MsgType msgType) {
        this.msgId = msgId;
        this.value = value;
        this.msgType = msgType;
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

}
