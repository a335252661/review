package B01_redis.A01_jedis;

import cn.hutool.json.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/1/4
 */
public class TestRedis01 {

    /**
     * String
     */
    @Test
    public void fun() {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());

        jedis.set("name" , "cld");
        jedis.set("age" , "12");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));

        jedis.append("name" , "2222222222");
        System.out.println(jedis.get("name"));

        jedis.mset("name","tantan","age","22","address","chongqin");
        System.out.println(jedis.mget("name", "age", "address"));

    }

    /**
     * 事务  multi
     */
    @Test
    public void fun1() {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","cld");
        jsonObject.put("age","22");

        jedis.flushDB();

        Transaction multi = jedis.multi();
        try {
            multi.set("user1" , jsonObject.toString());
            multi.set("user2" , jsonObject.toString());
            int i = 1/0;
            multi.set("user3" , jsonObject.toString());
            multi.exec();
        } catch (Exception e) {
            multi.discard();//放弃事务
            e.printStackTrace();
        }finally {
            System.out.println(jedis.mget("user1","user2","user3"));
        }

    }
}
