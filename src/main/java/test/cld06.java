package test;

import java.util.HashMap;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/28
 */
public class cld06 {
    public void get() {
        synchronized (this) {
            System.out.println("小张你好鸭！");
        }
    }

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        HashMap map = new HashMap();
        map.put(null,null);
        map.get(null);


    }

}
