package com.example.demo.game.role;

import com.example.demo.Cache.GameCache;
import com.example.demo.CacheEnumType;
import com.example.demo.bean.Role;

import com.example.demo.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoleManager {
    private final static Logger logger = LoggerFactory.getLogger(RoleManager.class);
    private volatile static RoleManager roleManager;
    private final static String ROLENAME = "小洛";
    private final static Integer TEN_THOUSAND = 10000;
    private final static Integer ONE_HUNDRED = 100;


    public RoleManager() {
    }
    public static RoleManager getMe(){
        if (roleManager == null){
            synchronized (RoleManager.class){
                if (roleManager == null){
                    roleManager = new RoleManager();
                }
            }
        }
        return roleManager;
    }

    /**
     * 创建角色 基础的属性
     */
    public void createRole(int money){
        Role role = new Role();
        role.setId((int) (System.currentTimeMillis()/1000));
        role.setName(ROLENAME);
        role.setLuckyValue(RandomUtils.randomValue(0,100));
        role.setMoney(money);
        int mood = generateMood(role);
        if (mood ==0){
            //发送前端错误码，提示玩家此次的创建角色开始新的一局失败
        }
        role.setMoodValue(mood);
        GameCache.getMe().putCacheItem(CacheEnumType.ROLE.getCacheType(),role);
    }

    /**
     * 随机生成内心舒缓值
     * 由携带的金钱*0.1+（幸运值/100)*random(90)
     * @return
     */
    private int generateMood(Role role){
        if (role == null){
            logger.error("角色role为空，请检查");
            return 0;
        }
        int mood = 1;
        int money = role.getMoney();
        int lucky = role.getLuckyValue();
        int calMoney = money*1000/TEN_THOUSAND;//携带的金钱*0.1(区间1-10分)
        calMoney = (calMoney>10?10 : calMoney)<1?1:calMoney;
        mood = RandomUtils.random(1,90)*lucky/ONE_HUNDRED+calMoney;
        return mood;
    }
}
