package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis测试类
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        jedis.set("username", "zhangsan");
        //3. 关闭连接
        jedis.close();
    }

    /**
     * String操作
     */
    @Test
    public void test2(){
        //1. 获取连接
        Jedis jedis = new Jedis(); //空参时默认赋localhost和6379端口
        //2. 操作
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        System.out.println(username);

        //可以用setex()方法存储可以指定过期时间的key value
        jedis.setex("activecode", 20, "hehe");//将activecode:hehe键值对存入redis, 并在20秒后自动删除


        //3. 关闭连接
        jedis.close();

    }


    /**
     * hash操作
     */
    @Test
    public void test3(){
        //1. 获取连接
        Jedis jedis = new Jedis(); //空参时默认赋localhost和6379端口
        //2. 操作
        //存储hash
        jedis.hset("user", "name", "zhangsan");
        jedis.hset("user", "age", "22");
        jedis.hset("user", "gender", "female");

        //获取hash
        Map<String, String> user = jedis.hgetAll("user");

        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            String value = user.get(key);
            System.out.println(key+":" + value);
        }
        //3. 关闭连接
        jedis.close();
    }

    /**
     * list操作
     */
    @Test
    public void test4(){
        //1. 获取连接
        Jedis jedis = new Jedis(); //空参时默认赋localhost和6379端口
        //2. 操作
        jedis.lpush("mylist", "a", "b", "c");
        jedis.rpush("mylist", "a", "b", "c");

        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);//[c, b, a, a, b, c]

        String ele1 = jedis.lpop("mylist");
        System.out.println(ele1);//c
        String ele2 = jedis.rpop("mylist");
        System.out.println(ele2);//c

        List<String> mylist1 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist1);//[b, a, a, b]
        //3. 关闭连接
        jedis.close();
    }

    /**
     * set操作
     */
    @Test
    public void test5(){
        //1. 获取连接
        Jedis jedis = new Jedis(); //空参时默认赋localhost和6379端口
        //2. 操作
        jedis.sadd("myset","java", "php", "c++");

        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);//[c++, java, php]
        //3. 关闭连接
        jedis.close();
    }

    /**
     * sortedset操作
     */
    @Test
    public void test6(){
        //1. 获取连接
        Jedis jedis = new Jedis(); //空参时默认赋localhost和6379端口
        //2. 操作
        jedis.zadd("mysortedset", 3, "盖伦");
        jedis.zadd("mysortedset", 30, "亚索");
        jedis.zadd("mysortedset", 25, "维鲁斯");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset); //[盖伦, 维鲁斯, 亚索]
        //3. 关闭连接
        jedis.close();
    }

    /**
     * 测试jedis
     */
    @Test
    public void test7(){
        //0. 创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //1. 创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
//        JedisPool jedisPool = new JedisPool(); //默认localhost, 6379

        //2. 获取连接
        Jedis jedis = jedisPool.getResource();
        //3. 使用
        jedis.set("hehe", "haha");
        //4. 将连接归还给连接池
        jedis.close();
    }

    /**
     * 测试JedisPoolUtils
     */
    @Test
    public void test8(){
       //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hello", "123");

        jedis.close();
    }
}
