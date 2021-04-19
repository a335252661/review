package JDK18.Lambda.A05_方法引用和构造器引用;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 *
 * 若 Lambda 表达式体中的内容已有方法实现，则我们可以使用“方法引用”
 * 双冒号（::）运算符在Java 8中被用作方法引用
 * 大致意思是，使用lambda表达式会创建匿名方法， 但有时候需要使用一个lambda表达式只调用一个已经存在的方法（不做其它）， 所以这才有了方法引用！
 * 语法格式：
 *
 * 对象 :: 实例方法
 * 类 :: 静态方法
 * 类 :: 实例方法
 */
public class TestLambda05 {
    private  static String fun(String name ) {
        System.out.println(name+"110");
        return name+"110";
    }
    @Test
    public void test01(){
        PrintStream ps = System.out;
//        Consumer<String> con1 = (s) -> ps.println(s);
//        con1.accept("aaa");

        Consumer<String> con2 = ps::println;
        con2.accept("bbb");
    }

    @Test
    public void fun() {
        List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
        //静态方法语法	ClassName::methodName        必须是静态方法 fun  compare
        list.forEach(TestLambda05::fun);
        list.forEach(s -> TestLambda05.fun(s));

        //前提 ， 方法的返回值要和 函数式接口中抽象方法（int compare(T o1, T o2);）的返回值一致
        Comparator<Integer> comparator1 = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> comparator = Integer::compare;

    }

    //类：：实例方法名
    @Test
    public void fun2() {

    }
}
