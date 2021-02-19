package com.example.demo;

public enum CacheEnumType {
    ROLE(1,"role","这个是每局人物相关数据的缓存")

    ;

    private int cacheType;
    private String key;
    private String explain;

    CacheEnumType(int cacheType, String key, String explain) {
        this.cacheType = cacheType;
        this.key = key;
        this.explain = explain;
    }

    public int getCacheType() {
        return cacheType;
    }

    public void setCacheType(int cacheType) {
        this.cacheType = cacheType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

}
