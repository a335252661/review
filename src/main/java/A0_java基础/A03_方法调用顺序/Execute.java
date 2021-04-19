package A0_java基础.A03_方法调用顺序;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 */
public class Execute {
    static {
        System.out.println("Execute的静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("执行main方法");
        new Children();
    }


}
