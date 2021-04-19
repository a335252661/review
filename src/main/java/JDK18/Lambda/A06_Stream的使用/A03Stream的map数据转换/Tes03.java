package JDK18.Lambda.A06_Stream的使用.A03Stream的map数据转换;

import JDK18.Lambda.A06_Stream的使用.A02_filter和谓词逻辑.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/29
 */
public class Tes03 {
    List<Employee> employeesData = Arrays.asList(
            new Employee(1, 22, "man", "cld", "c"),
            new Employee(2, 23, "man", "cld", "c"),
            new Employee(3, 24, "women", "cld", "c"),
            new Employee(4, 25, "man", "cld", "c"),
            new Employee(5, 26, "women", "cld", "c")
    );


    //集合都可以这么操作
    List<String> dataLists = Arrays.asList("mml", "kend", "cld", "kenmo");


    @Test
    public void fun() {
        List<String> collectData = dataLists.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collectData);

        List<String> collectData2 = dataLists.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collectData2);

        Stream.of("mml", "kend", "cld", "kenmo")
                .mapToInt(String::length)
                .forEach(System.out::println);
    }

    @Test
    public void fun2() {
        employeesData.stream()
                .map(s ->{
                    s.setAge(s.getAge()+1);
                    s.setGender("women");
                    return s;
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //对象传递进去方法，进入方法体的是对象的拷贝，原始对象和对象的拷贝指向的是同一个堆内存地址
        //对象的靠谱修改对象内容（修改的是堆内存的内容），所以，原始对象也会改变。
        //peek函数，入参和出参都是同一个

        employeesData.stream()
                .peek(s ->{
                    s.setAge(s.getAge()+1);
                    s.setGender("man");
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    @Test
    public void fun3() {
        List<String> dataLists = Arrays.asList("hello", "world");
        dataLists.stream()
                .map(s -> Arrays.stream(s.split("")))
                .forEach(System.out::println);

        dataLists.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .forEach(System.out::println);

    }

}
