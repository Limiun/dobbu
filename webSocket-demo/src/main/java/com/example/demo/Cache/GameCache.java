package com.example.demo.Cache;

import io.netty.util.internal.chmv8.ConcurrentHashMapV8;

import java.util.Map;

public class GameCache {
    private volatile static GameCache gameCache;
    private volatile Map<Object,Object> gameCacheItems;

    public GameCache() {
        gameCacheItems = new ConcurrentHashMapV8<Object, Object>();
    }
    /**
     * 获取唯一实例
     **/
    public static GameCache getMe() {
        if (gameCache == null) {
            synchronized (GameCache.class) {
                if (gameCache == null)
                    gameCache = new GameCache();
            }
        }
        return gameCache;
    }


    /**
     * 清空cache
     **/
    public void clearAllItems(){
        gameCacheItems.clear();
    }
    /**
     * 获取指定的cache信息
     * @param key 唯一标识
     * @return Object cacheItem
     */
    public Object getCacheItem(Object key){
        if (gameCacheItems.containsKey(key)){
            return gameCacheItems.get(key);
        }
        return null;
    }

    /**
     * 存值
     */
    public Boolean putCacheItem(Object key,Object value){
        if (!gameCacheItems.containsKey(key)){
            gameCacheItems.put(key,value);
            return true;
        }
        return false;
    }
    /**
     * 根据key删除
     * @@@袁新瑜：我记得这里用map和list的remove,有可能出错，后续看一下需不需要改成迭代器移除的方式
     * @param key 唯一标识
     */
    public void removeCacheItem(Object key){
        if (gameCacheItems.containsKey(key)){
            gameCacheItems.remove(key);
        }
    }

    /**
     * 获取cache长度
     *
     * @return size
     */
    public int getSize() {
        return gameCacheItems.size();
    }
}
