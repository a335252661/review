package JDK18.Lambda.A04_内置四大核心函数式接口;

import lombok.val;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 */
public class TestLambda04 {

    //消费性接口Consumer
    @Test
    public void fun() {
        Consumer<String> con = m -> System.out.println(m);
        con.accept("哈哈哈哈哈哈哈哈哈哈哈");
    }
    //供给形接口
    @Test
    public void fun2() {
        Supplier<Integer> su = () ->{
            return 1;
        };
        Integer integer = su.get();
        System.out.println(integer);
    }

    //函数型接口
    @Test
    public void fun3() {
        Function<Integer,Integer> A=i->i+1;
        Function<Integer,Integer> B=i->i*i;
        System.out.println("F1:"+B.apply(A.apply(5)));
        System.out.println("F1:"+B.compose(A).apply(5));
        System.out.println("F2:"+A.apply(B.apply(5)));
        System.out.println("F2:"+B.andThen(A).apply(5));

    }

    //Predicate<T>
//    Integer age = 35;
//    Predicate<Integer> predicate = (i) -> i >= 35;
//    if (predicate.test(age)){
//        System.out.println("你该退休了");
//    } else {
//        System.out.println("我觉得还OK啦");
//    }
}
