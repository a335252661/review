package JDK18.Lambda.A06_Stream的使用.A02_filter和谓词逻辑;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/29
 */
@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private Integer age;
    private String gender;
    private String fristName;
    private String lastName;

    //复用的谓词逻辑  ，也就是可以复用的条件语句
    public static Predicate<Employee> ageThan24 = x -> x.getAge()>=24;
    public static Predicate<Employee> iswomem = x -> x.getGender().equals("women");
}
