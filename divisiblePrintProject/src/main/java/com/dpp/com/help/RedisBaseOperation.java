package com.dpp.com.help;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RedisBaseOperation {
    private Jedis jedis;
    private final static String IP = "192.168.31.103";
    private final static int PORT = 6379;
    private final static int MAX_ACTIVE = 1024;
    private final static int MAX_IDLE = 200;
    private final static long MAX_WAIRT = 1000;
    private final static Boolean BLOCK_WHEN_EXHAUSTED = true;
    private JedisPoolConfig config;
    private JedisPool pool = null;
    private final static String KEY_NAME = "numberList";

    private JedisPoolConfig getJedisPoolConfig(){

            config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setBlockWhenExhausted(BLOCK_WHEN_EXHAUSTED);
            config.setMaxWaitMillis(MAX_WAIRT);
            config.setMaxIdle(MAX_IDLE);
            return config;
    }

    public Jedis initJedisSentinelPool(){
        if(config == null || pool == null){
            config = getJedisPoolConfig();
            pool = new JedisPool(config,IP, PORT);
            jedis = pool.getResource();
            jedis.auth("Chnsh12Ol2012");
        }
        return jedis;

    }

    public void setList(int numberBegin, int numberEnd){
        for(int i = numberEnd; i >= numberBegin; i--){
           jedis.lpush(KEY_NAME, String.valueOf(i));
        }

    }
    public List<String> getList(){
       List<String> list =  jedis.lrange(KEY_NAME,0,-1);
        return list;
    }

    public void cleanList(){
        jedis.lpop(KEY_NAME);
    }

    public void deletRecord(){
        jedis.del(  KEY_NAME );
    }


}
