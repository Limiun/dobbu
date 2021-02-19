package com.example.demo.bean;

import lombok.Data;

@Data
public class Event {
    //模板id
    private Integer modelId;
    //事件id
    private Integer id;
    //事件名称
    private String name;
    //事件触发条件集合String
    private String eventConditionStr;
    //后续触发事件集合String
    private String nextEventStr;
    //事件得分计算系数值
    private Integer scoreCoefficient;

}
