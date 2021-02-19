package com.example.demo.game.initGame;

import com.example.demo.Cache.GameCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 初始化游戏开始时的管理类
 */
public class InitGameManager {
    private final static Logger logger = LoggerFactory.getLogger(InitGameManager.class);
    private volatile static InitGameManager initGame;

    public InitGameManager() {
    }
    public static InitGameManager getMe(){
        if (initGame == null){
            synchronized (InitGameManager.class){
                if (initGame == null){
                    initGame = new InitGameManager();
                }
            }
        }
        return initGame;
    }

    /**
     * 玩家点击开始一局新的游戏的时候才会调用
     */
    public void initGame(){
        //以防万一清除上局一局游戏的缓存
        GameCache.getMe().clearAllItems();
        //初始化role


        //初始化地图（地图管理类里 初始化当前的地图的所有npc）
        //

    }


}
