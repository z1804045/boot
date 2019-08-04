package com.itheima;


import com.itheima.domain.User;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cash {

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作字符串的

    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象
    @Autowired
    RedisTemplate<Object,User> ticketRedisTemplate;


    /*
    * Redis常见的五大数据类型
    * String(字符串),list(列表),set(集合),Hash(散列),ZSet(有序集合)
    *  stringRedisTemplate.opsForValue();//String字符串
    *  stringRedisTemplate.opsForList();//List列表
    *  stringRedisTemplate.opsForSet();//Set集合
    *  stringRedisTemplate.opsForHash();//Hash(散列)
    *  stringRedisTemplate.opsForZSet();//ZSet(有序集合)
    * */
    @Test
    public void test01(){
        //给redis中保存数据

        //stringRedisTemplate.opsForValue().append("msg","hello");
        //String msg = stringRedisTemplate.opsForValue().get("msg");
        //System.out.println(msg);

        //stringRedisTemplate.opsForList().leftPush("mylist","1");
        //stringRedisTemplate.opsForList().leftPush("mylist","2");
    }

    //测试保存对象
    //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
    //1，将数据以json的方式保存
    //(1)自己将对象转为json
    //(2)redisTemplate默认的序列化规则
    @Test
    public void test02(){
        User user = new User();
        user.setUsername("sadawdawd");
        // redisTemplate.opsForValue().set("emp-01","xtt");
        stringRedisTemplate.opsForValue().set("emp3", String.valueOf(user));
        ticketRedisTemplate.opsForValue().set("emp4",user);

    }


}
