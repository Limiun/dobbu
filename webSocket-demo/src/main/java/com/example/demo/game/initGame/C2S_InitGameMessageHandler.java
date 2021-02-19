package com.example.demo.game.initGame;


import com.example.demo.C2S_MessageScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C2S_InitGameMessageHandler extends C2S_MessageScript {
    private final static Logger logger = LoggerFactory.getLogger(C2S_InitGameMessageHandler.class);
    private volatile static C2S_InitGameMessageHandler initGameMessage;

    public static C2S_InitGameMessageHandler getMe(){
        if (initGameMessage == null){
            synchronized (C2S_InitGameMessageHandler.class){
                if (initGameMessage == null){
                    initGameMessage = new C2S_InitGameMessageHandler();
                }
            }
        }
        return initGameMessage;
    }

    @Override
    public void action() {
        System.out.println("init");
    }
}
