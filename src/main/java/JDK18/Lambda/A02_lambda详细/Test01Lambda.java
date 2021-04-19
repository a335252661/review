package JDK18.Lambda.A02_lambda详细;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 *
 * lambda表达式需要函数式接口的支持
 * 函数式接口：接口中直至有一个抽象方法的接口
 * 可以用 @FunctionInteface修饰一下检查下是否是函数式接口
 *
 */
public class Test01Lambda {

    //无参数无返回值
    @Test
    public void fun() {
        //匿名内部类调用局部变量，该变量必须是final的，1.8时候不用写final，内部给我们加上了
        int num = 100;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello" + num);
            }
        };
        r.run();
        new Thread(r).start();
        System.out.println("---------------------------");
        Runnable r2 = () -> System.out.println("hello lambda");
        r2.run();
        new Thread(r2).start();

    }

    //有参数无返回值
    @Test
    public void fun2() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("你好呀");
    }

    //多个入参，有返回加return
    @Test
    public void fun3() {
        Comparator<Integer> con = (x,y) -> {
            return Integer.compare(x,y);
        };
    }

}
