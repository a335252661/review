package A1_多线程.A22synchronized同步语句块.A2213类Class的单例性;

import java.text.SimpleDateFormat;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/21
 *
 * 每一个*.java文件对应Class类的实例都是一个，
 * 在内存中是单例的，测试代码如下
 *
 * Class类用于描述类的基本信息，包括有多少个
 * 字段，有多少个构造方法，有多少个普通方法等，
 * 为了减少对内存的高占用率，在内存中只需要存在
 * 一份Class类对象就可以了，所以被设计成是单例
 * 的。
 *
 */

class MyTest {
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyTest test1 = new MyTest();
        MyTest test2 = new MyTest();
        MyTest test3 = new MyTest();
        MyTest test4 = new MyTest();
        System.out.println(test1.getClass() == test1.getClass());
        System.out.println(test1.getClass() == test2.getClass());
        System.out.println(test1.getClass() == test3.getClass());
        System.out.println(test1.getClass() == test4.getClass());
//
        System.out.println();
//
        SimpleDateFormat format1 = new SimpleDateFormat("");
        SimpleDateFormat format2 = new SimpleDateFormat("");
        SimpleDateFormat format3 = new SimpleDateFormat("");
        SimpleDateFormat format4 = new SimpleDateFormat("");
        System.out.println(format1.getClass() == format1.getClass());
        System.out.println(format1.getClass() == format2.getClass());
        System.out.println(format1.getClass() == format3.getClass());
        System.out.println(format1.getClass() == format4.getClass());
    }
}
