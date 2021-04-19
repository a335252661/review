package JDK18.Lambda.A06_Stream的使用.A04有状态操作;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/1/2
 */
public class Test04 {
    List<String> dataLists = Arrays.asList("mml", "kend", "cld", "kenmo","kenmo");

    //有状态操作limit  skip  distinct  sorted
    //并行时候不要用有状态操作
    @Test
    public void fun() {
        List<String> collect = dataLists.stream().limit(2).collect(Collectors.toList());
        System.out.println(collect);

        dataLists.stream().skip(2).forEach(System.out::println);
        dataLists.stream().distinct().forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        dataLists.stream().sorted().forEach(System.out::println);
    }
    @Test
    public void fun2() {
        dataLists.stream()
                .parallel() //进行并行操作
                .skip(2)
                .forEach(System.out::println);
    }
}
