package com.human.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class RedisDb {
    private static JedisPool jedisPool;
    // session 在redis过期时间是30分钟30*60
    private static int expireTime = 1800;
    // 计数器的过期时间默认2天
    private static int countExpireTime = 2*24*3600;
    private static String password = "123456";
    private static String redisIp = "120.79.15.183";
    private static int redisPort = 3306;
    private static int maxActive = 200;
    private static int maxIdle = 200;
    private static long maxWait = 5000;
    private static Logger logger = LoggerFactory.getLogger(RedisDb.class);

    static {
        initPool();
    }
    // 初始化连接池
    public static void initPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxActive);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWait);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config, redisIp, redisPort, 10000, password);
    }
    // 从连接池获取redis连接
    public static Jedis getJedis(){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
//            jedis.auth(password);
        } catch(Exception e){
            System.out.println("eer");
        }

        return jedis;
    }
    // 回收redis连接
    public static void recycleJedis(Jedis jedis){
        if(jedis != null){
            try{
                jedis.close();
            } catch(Exception e){
                System.out.println("eer");
            }
        }
    }
    // 保存字符串数据
    public static void setString(String key, String value){
        Jedis jedis = getJedis();
        if(jedis != null){
            try{
                jedis.set(key, value);
            } catch(Exception e){
                System.out.println("eer");
            } finally{
                recycleJedis(jedis);
            }
        }

    }
    // 获取字符串类型的数据
    public static String getString(String key){
        Jedis jedis = getJedis();
        String result = "";
        if(jedis != null){
            try{
                result = jedis.get(key);
            }catch(Exception e){
                System.out.println("eer");
            } finally{
                recycleJedis(jedis);
            }
        }

        return result;
    }
    // 删除字符串数据
    public static void delString(String key){
        Jedis jedis = getJedis();
        if(jedis != null){
            try{
                jedis.del(key);
            }catch(Exception e){
                System.out.println("eer");
            } finally{
                recycleJedis(jedis);
            }
        }
    }
    // 保存byte类型数据
    public static void setObject(byte[] key, byte[] value){
        Jedis jedis = getJedis();
        String result = "";
        if(jedis != null){
            try{
                if(!jedis.exists(key)){
                    jedis.set(key, value);
                }
                // redis中session过期时间
                jedis.expire(key, expireTime);
            } catch(Exception e){
                System.out.println("eer");
            } finally{
                recycleJedis(jedis);
            }
        }
    }
    // 获取byte类型数据
    public static byte[] getObject(byte[] key){
        Jedis jedis = getJedis();
        byte[] bytes = null;
        if(jedis != null){
            try{
                bytes = jedis.get(key);;
            }catch(Exception e){
              System.out.println("eer");
            } finally{
                recycleJedis(jedis);
            }
        }
        return bytes;

    }

    // 更新byte类型的数据，主要更新过期时间
    public static void updateObject(byte[] key){
        Jedis jedis = getJedis();
        if(jedis != null){
            try{
                // redis中session过期时间
                jedis.expire(key, expireTime);
            }catch(Exception e){
                System.out.println("eer");
            } finally{
                recycleJedis(jedis);
            }
        }

    }

    // key对应的整数value加1
    public static void inc(String key){
        Jedis jedis = getJedis();
        if(jedis != null){
            try{
                if(!jedis.exists(key)){
                    jedis.set(key, "1");
                    jedis.expire(key, countExpireTime);
                } else {
                    // 加1
                    jedis.incr(key);
                }
            }catch(Exception e){
                System.out.println("eer");
            } finally{
                recycleJedis(jedis);
            }
        }
    }

    // 获取所有keys
    public static Set<String> getAllKeys(String pattern){
        Jedis jedis = getJedis();
        if(jedis != null){
            try{
                return jedis.keys(pattern);
            }catch(Exception e){
                System.out.println("eer");
            } finally{
                recycleJedis(jedis);
            }
        }
        return null;
    }

}