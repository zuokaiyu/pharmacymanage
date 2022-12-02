package com.pyy.pharmacy.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pyy.pharmacy.order.controller.Test;
import com.pyy.pharmacy.order.dao.PyyOrderDao;
import com.pyy.pharmacy.order.entity.PyyOrder;
import com.pyy.pharmacy.order.service.IOrderService;
import jdk.nashorn.internal.ir.CallNode;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.*;

import java.sql.Wrapper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    PyyOrderDao pyyOrderDao;
    @Autowired
    Logger logger;
    @Autowired
    RedisTemplate redisTemplate;

    private JedisPool jedisPool = new JedisPool("redis",6379);
    //private JedisPooled jedisPooled= new JedisPooled("redis",6379);


    //高可用连接（主从）
    /*
    private JedisSentinelPool jedisSentinelPool;
    {
        Set<String> sentinels =new HashSet<>();
        sentinels.add("redis:26380");
        sentinels.add("redis:26381");
        sentinels.add("redis:26382");
        jedisSentinelPool =new JedisSentinelPool("mymaster",sentinels);
    }
*/
    //分布式redis
    /*
    private JedisCluster jedisCluster;
    {
        Set<HostAndPort> nodes =new HashSet<>();
        nodes.add(new HostAndPort("redis",6380));
        nodes.add(new HostAndPort("redis",6381));
        nodes.add(new HostAndPort("redis",6382));
        nodes.add(new HostAndPort("redis",6383));
        nodes.add(new HostAndPort("redis",6384));
        nodes.add(new HostAndPort("redis",6385));
        jedisCluster =new JedisCluster(nodes);
    }
    */



    @Override
    public void add(PyyOrder pyyOrder) {
        pyyOrderDao.insert(pyyOrder);
    }

    @Override
    public List<PyyOrder> selectAll() {
        QueryWrapper queryWrapper=new QueryWrapper();
        //分页
        Page<PyyOrder> objectPage = new Page<>(1,5);
        pyyOrderDao.selectPage(objectPage,null);
        // 删除
        pyyOrderDao.deleteById(1);//逻辑删除

        logger.info("a");



        return pyyOrderDao.selectList(null);
    }
    //redis事务
    public void test(){
        try(Jedis jedis=jedisPool.getResource()){
            jedis.set("name","a");
            jedis.set("age","12");


            jedis.watch("age");//加了乐观锁，通过版本号判断数据一致性
            Transaction tx =jedis.multi();
            try {
                tx.set("name", "lisi");
                int i = 3 / 0;
                tx.set("age", "25");
                tx.exec();
            }catch (Exception e){
                //回滚
                tx.discard();
            }finally {
                System.out.println(jedis.get("name"));
                System.out.println(jedis.get("age"));
            }
        }


    }
    public void jedis(){
        //每次建立连接
        /*
        Jedis redis = new Jedis("redis", 6379);
        redis.set("name","zhangsan");
        redis.hset("emp","s","s");
        redis.close();
        */

        //连接池方式

       /* try(Jedis jedis=jedisPool.getResource()){
            jedis.set("name","a");

        }*/
    }
    public void reidisTem(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name","a");
        BoundValueOperations<Object,Object> name = redisTemplate.boundValueOps("name");
        name.set("a",10, TimeUnit.SECONDS);//过期时间10秒
    }
}
