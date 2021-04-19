package A1_多线程.A33_类ThreadLocal的使用.A334_测试;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/26
 */
public class Test01 {
    private String name ="name";  //成员变量 全局变量
    private static String staName ="name";  //静态变量
    public void fun() { //成员方法
        String some = "";  //局部变量
    }

    public void fun3() { //成员方法
        class funClass{  //局部内部类
            public void fun() {
                System.out.println(name);
            }
        }
    }
    class InnerClass{//成员内部类
        public void fun2() {
            //内部类可以访问外部类的 所有
            System.out.println(name);
            System.out.println(staName);
            fun();
        }
    }
    static class  InnerClass2{  //静态内部类
        public void fun2() {
            //静态内部类 只能访问外部类的 静态变量和静态方法
            System.out.println(staName);
        }
    }
}
