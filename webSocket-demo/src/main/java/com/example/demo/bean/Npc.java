package com.example.demo.bean;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Npc {
    //模板id
    private Integer modelId;
    //唯一id
    private Integer id;
    //npc名字
    private String name;
    //npc当前事件可触发事件modelid
    private Integer nowEventModelId;
    //npc可触发后续的事件modelid
    private List<Integer> eventModelIdList = new LinkedList<>();



}
