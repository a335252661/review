package JDK18.Lambda.A06_Stream的使用.A05排序;

import JDK18.Lambda.A06_Stream的使用.A02_filter和谓词逻辑.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/1/2
 */
public class Test06 {
    List<Employee> employeesData = Arrays.asList(
            new Employee(1, 22, "man", "cld", "c"),
            new Employee(2, 23, "man", "cld", "c"),
            new Employee(3, 24, "women", "cld", "c"),
            new Employee(4, 25, "man", "cld", "c"),
            new Employee(5, 26, "women", "cld", "c")
    );
    @Test
    public void fun() {
//        employeesData.stream()
//                .forEach(System.out::println);
//        System.out.println( 1);

        employeesData.sort(
                Comparator.comparing(Employee::getAge)
                .reversed()
        );
        employeesData.forEach(System.out::println);
    }
}
