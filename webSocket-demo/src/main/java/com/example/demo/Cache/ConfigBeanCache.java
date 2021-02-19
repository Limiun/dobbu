package com.example.demo.Cache;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigBeanCache {
    private volatile static ConfigBeanCache configBeanCache;
    private volatile Map<Object, Object> configBeanCacheItems;

    public ConfigBeanCache() {
        configBeanCacheItems = new ConcurrentHashMap<Object, Object>();
    }

    /**
     * 获取唯一实例
     **/
    public static ConfigBeanCache getMe() {
        if (configBeanCache == null) {
            synchronized (ConfigBeanCache.class) {
                if (configBeanCache == null)
                    configBeanCache = new ConfigBeanCache();
            }
        }
        return configBeanCache;
    }

    /**
     * 清空cache
     **/
    private void clearAllItems() {
        configBeanCacheItems.clear();
    }

    /**
     * 获取指定的cache信息
     * @param key 唯一标识
     * @return Object cacheItem
     */
    public  Object getCacheItem(Object key){
        if (configBeanCacheItems.containsKey(key)){
            return configBeanCacheItems.get(key);
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
        if (!configBeanCacheItems.containsKey(key)) {
            configBeanCacheItems.put(key, value);
            return true;
        }
        if ((int)key==1){
            configBeanCacheItems.remove(1);
            configBeanCacheItems.put(key,value);
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
        if (configBeanCacheItems.containsKey(key)) {
            configBeanCacheItems.remove(key);
        }
    }

    /**
     * 获取cache长度
     *
     * @return size
     */
    public int getSize() {
        return configBeanCacheItems.size();
    }
}
