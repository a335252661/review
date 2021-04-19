package A0_java基础.A04_接口和抽象类;

import java.util.Comparator;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 */
public interface Tset01 extends Runnable, Comparator  {
     static String kk="2";
    final String mm2 = "1";
    final static String kk2="2";
    String mm="2";

    public void fun() ;
    void fun4() ;
    default  void fun7() {};

    public abstract  void fun8();

    public static void fun2(){

    };

    public void Tset01();

    interface test02{
    }
    class test03{
    }

}
