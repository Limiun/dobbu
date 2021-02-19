package com.example.demo.bean;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import io.netty.util.internal.chmv8.ConcurrentHashMapV8;
import lombok.Data;

@Data
public class Map {
    //模板id
    private Integer modelId;
    //地图id
    private Integer mapId;
    //地图名称
    private String mapName;
    //地图所容纳npc人数
    private Integer npmNum;
    //地图npc列表
    private ConcurrentMap<Integer,List<Npc>> npcs = new ConcurrentHashMapV8<>();
    //地图所能触发事件 <id,具体事件（同一id可能有不同事件数据）>
    private ConcurrentMap<Integer,List<Npc>> eventCanList = new ConcurrentHashMapV8<>();
    //进入当前地图的时间戳
    private List<Long> intoMapTime = new LinkedList<>();
    //离开当前地图的时间戳
    private List<Long> leaveMapTime = new LinkedList<>();
    //地图进入条件
    private String conditionStr;




}
