package com.example.demo.bean;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
public class Player {
    //玩家id
    private Integer id;
    //玩家账户
    private String account;
    //玩家的签名或者token之类的
    private String sign;

    //玩家目前充值金币
    private Integer money_Recharge;
    //玩家获得的额外的金币
    private Integer money_Get;
    //玩家死亡次数
    private Integer dieNum;
    //玩家完成事件获取的总得分
    private Integer score;
    //玩家已体验过的事件
    private Set<Integer> eventFinished;
    //玩家事件完成进度万分比 分子
    private Integer FinishedMolecule;




}
