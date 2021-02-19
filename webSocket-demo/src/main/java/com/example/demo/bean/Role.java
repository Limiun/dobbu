package com.example.demo.bean;

import io.netty.util.internal.chmv8.ConcurrentHashMapV8;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Data
public class Role {
    //角色id
    private Integer id;
    //角色名称
    private String name;
    //幸运值
    private Integer luckyValue;
    //内心舒缓值
    private Integer moodValue;
    //携带金钱
    private Integer money;

    /*上面是初始化role的时候需要赋值的，下面是后续的变化改变的*/

    //已触发事件(第一个是事件id，第二个是完成情况)
    private ConcurrentMap<Integer,Integer> eventFinishedData = new ConcurrentHashMapV8<>();
    //等待触发事件 事件id
    private ConcurrentMap<Integer,List<Event>> eventWaitingData = new ConcurrentHashMapV8<>();
    //目前所在的地图段id
    private Integer mapId;
    //影响结局事件<事件id,事件得分>
    private ConcurrentMap<Integer,Integer> eventinFluenceEndingData;


}
