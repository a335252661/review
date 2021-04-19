package A0_java基础.A03_方法调用顺序;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 */
public class Father{
    static String nameFather = putName();
    static String nameFather2 = putName();
    static String nameFather3 = putName();
    static {
        System.out.println("Father的静态代码块");
    }


    String nameFather4 = putNamenotstatic();
    String nameFather5 = putNamenotstatic();
    String nameFather6 = putNamenotstatic();
    {
        System.out.println("Father的构造代码块");
    }
    public Father() {
        System.out.println("Father的构造方法");
    }

    public static String putName() {
        System.out.println("Father静态变量赋值");
        return "cld001";
    }

    public  String putNamenotstatic() {
        System.out.println("Father变量赋值");
        return "cld008";
    }
}
