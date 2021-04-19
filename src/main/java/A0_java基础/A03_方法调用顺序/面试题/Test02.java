package A0_java基础.A03_方法调用顺序.面试题;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/4/2
 */
class Father{

}
class Son extends  Father{



}

public class Test02 {
    static {
        System.out.println("第一、静态代码块");
    }
    private static String name2 =fun2();
    public static String fun2() {
        System.out.println("第二、静态属性");
        return "";
    }
    {
        System.out.println("第三、代码块");
    }
    private String name =fun();
    public String fun() {
        System.out.println("第四、属性初始化");
        return "";
    }
    public Test02(){
        System.out.println("第五、构造方法");
    }

    public static void main(String[] args) {
        new Test02();
    }

}
