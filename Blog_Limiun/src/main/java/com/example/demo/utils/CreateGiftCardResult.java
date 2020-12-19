package com.example.demo.utils;

import java.io.Serializable;
import java.util.Set;

public class CreateGiftCardResult implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String desc;
    private int cardId;
    private String webName;
    private int zoneId;
    private int startTime;
    private long startRandom;
    private int limitDay;
    private String loginAgentAd;
    private Set<String> cdKeys;
    private int runNum;
    private int sumCreate;
    private int failNum;
    private long endRandom;
    private int endTime;
    
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(final String desc) {
        this.desc = desc;
    }
    
    public int getCardId() {
        return this.cardId;
    }
    
    public void setCardId(final int cardId) {
        this.cardId = cardId;
    }
    
    public String getWebName() {
        return this.webName;
    }
    
    public void setWebName(final String webName) {
        this.webName = webName;
    }
    
    public int getZoneId() {
        return this.zoneId;
    }
    
    public void setZoneId(final int zoneId) {
        this.zoneId = zoneId;
    }
    
    public int getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(final int startTime) {
        this.startTime = startTime;
    }
    
    public long getStartRandom() {
        return this.startRandom;
    }
    
    public void setStartRandom(final long startRandom) {
        this.startRandom = startRandom;
    }
    
    public int getLimitDay() {
        return this.limitDay;
    }
    
    public void setLimitDay(final int limitDay) {
        this.limitDay = limitDay;
    }
    
    public String getLoginAgentAd() {
        return this.loginAgentAd;
    }
    
    public void setLoginAgentAd(final String loginAgentAd) {
        this.loginAgentAd = loginAgentAd;
    }
    
    public Set<String> getCdKeys() {
        return this.cdKeys;
    }
    
    public void setCdKeys(final Set<String> cdKeys) {
        this.cdKeys = cdKeys;
    }
    
    public int getRunNum() {
        return this.runNum;
    }
    
    public void setRunNum(final int runNum) {
        this.runNum = runNum;
    }
    
    public int getSumCreate() {
        return this.sumCreate;
    }
    
    public void setSumCreate(final int sumCreate) {
        this.sumCreate = sumCreate;
    }
    
    public int getFailNum() {
        return this.failNum;
    }
    
    public void setFailNum(final int failNum) {
        this.failNum = failNum;
    }
    
    public long getEndRandom() {
        return this.endRandom;
    }
    
    public void setEndRandom(final long endRandom) {
        this.endRandom = endRandom;
    }
    
    public int getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(final int endTime) {
        this.endTime = endTime;
    }
}
