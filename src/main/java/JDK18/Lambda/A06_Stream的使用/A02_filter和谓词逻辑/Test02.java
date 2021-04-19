package JDK18.Lambda.A06_Stream的使用.A02_filter和谓词逻辑;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/29
 */
public class Test02 {
    List<Employee> employeesData = Arrays.asList(
            new Employee(1, 22, "man", "cld", "c"),
            new Employee(2, 23, "man", "cld", "c"),
            new Employee(3, 24, "women", "cld", "c"),
            new Employee(4, 25, "man", "cld", "c"),
            new Employee(5, 26, "women", "cld", "c")
    );
    @Test
    public void fun() {
        List<Employee> womenList = employeesData.stream()
                .filter(e -> e.getAge() >= 24 && e.getGender().equals("women"))
                .collect(Collectors.toList());
        System.out.println(womenList);

        List<Employee> womenList2 = employeesData.stream()
                .filter(Employee.ageThan24.and(Employee.iswomem))
                .collect(Collectors.toList());
        System.out.println(womenList2);

        List<Employee> womenList3 = employeesData.stream()
                .filter(Employee.ageThan24.and(Employee.iswomem).negate()) //取反
                .collect(Collectors.toList());
        System.out.println(womenList3);

    }
}
