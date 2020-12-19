package com.example.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    private static JedisPool jedisPool;
    static {
        JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(20);
        jedisPool = new JedisPool(jedisPoolConfig,"47.114.157.175",6379,3000,"123456");

    }
    public static Jedis getJedis(){
        if(null!= jedisPool){
            return jedisPool.getResource();
        }
        throw new RuntimeException("pool not ok");
    }
}
