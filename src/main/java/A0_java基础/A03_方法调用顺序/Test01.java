package A0_java基础.A03_方法调用顺序;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 */
public class Test01 {
    static {
        System.out.println("Test01的静态代码块");
    }
    {
        System.out.println("Test01的构造代码块");
    }
    public Test01() {
        System.out.println("Test01的构造方法");
    }
    public void fun() {
        System.out.println("普通方法");
    }

    public static void main(String[] args) {
        new Test01().fun();
    }

}
