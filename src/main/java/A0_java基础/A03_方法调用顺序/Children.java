package A0_java基础.A03_方法调用顺序;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 */
public class Children extends  Father{
    static String nameChildren = putNameChild();
    static String nameChildren2 = putNameChild();
    static String nameChildren3 = putNameChild();
    static {
        System.out.println("Children的静态代码块");
    }

     String nameChildren4 = putNameChildnotstatic();
     String nameChildren5 = putNameChildnotstatic();
     String nameChildren6 = putNameChildnotstatic();
    {
        System.out.println("Children的构造代码块");
    }
    public Children() {
        System.out.println("Children的构造方法");
    }

    public static String putNameChild() {
        System.out.println("Children静态变量赋值");
        return "cld002";
    }
    public  String putNameChildnotstatic() {
        System.out.println("Children变量赋值");
        return "cld002";
    }
  
}
