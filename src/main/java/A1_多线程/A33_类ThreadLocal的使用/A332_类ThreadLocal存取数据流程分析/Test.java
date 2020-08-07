package A1_多线程.A33_类ThreadLocal的使用.A332_类ThreadLocal存取数据流程分析;

import java.io.IOException;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/27
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        ThreadLocal local = new ThreadLocal();
        local.set("我是任意的值");
        System.out.println(local.get());
    }
}
