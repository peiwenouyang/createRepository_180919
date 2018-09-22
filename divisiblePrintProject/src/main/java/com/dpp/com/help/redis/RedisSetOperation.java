package com.dpp.com.help.redis;

import java.util.List;

public class RedisSetOperation {
    private RedisBaseOperation rbo;
    private RedisSetOperation(){
        if(rbo == null) {
            rbo = new RedisBaseOperation();
            rbo.initJedisSentinelPool();
        }
    }
    public static RedisSetOperation getRso(){
        return new RedisSetOperation();
    }

    public void setList(int numberBegin, int numberEnd){
        rbo.setList(numberBegin, numberEnd);
    }
    public List<String> getList(){
        List<String> list = rbo.getList();
        rbo.cleanList();
        rbo.deletRecord();
        return list;
    }

}
