package com.example.demo.Cache;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SaveCache {
    private static SaveCache SaveCache;
    private Map<Object, Object> cacheItems;

    public SaveCache() {
        cacheItems = new ConcurrentHashMap<Object, Object>();
    }

    /**
     * 获取唯一实例
     **/
    public static SaveCache getMe() {
        if (SaveCache == null) {
            synchronized (SaveCache.class) {
                if (SaveCache == null) SaveCache = new SaveCache();
            }
        }
        return SaveCache;
    }

    /**
     * 清空cache
     **/
    private void clearAllItems() {
        cacheItems.clear();
    }

    /**
     * 获取指定的cache信息
     * @param key 唯一标识
     * @return Object cacheItem
     */
    public  Object getCacheItem(Object key){
        if (cacheItems.containsKey(key)){
            return cacheItems.get(key);
        }
        return null;
    }

    /**
     * 存值
     *
     * @param key 唯一标识
     * @param value 存放的值
     * */
    public Boolean putCacheItem(Object key, Object value) {
        if (!cacheItems.containsKey(key)) {
            cacheItems.put(key, value);
            return true;
        }
        if ((int)key==1){
            cacheItems.remove(1);
            cacheItems.put(key,value);
            return true;
        }
        return false;
    }

    /**
     * 根据key删除
     *
     * @param key 唯一标识
     */
    public void removeCacheItem(Object key) {
        if (cacheItems.containsKey(key)) {
            cacheItems.remove(key);
        }
    }

    /**
     * 获取cache长度
     *
     * @return size
     */
    public int getSize() {
        return cacheItems.size();
    }
}
