package JDK18.Lambda.A03_简单练习;

import JDK18.Lambda.bean.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 * 1\排序，想按照年龄排序，年龄一样，按照工资排序
 * 2\策略模式，对两个数据进行处理
 */
public class TestLambda03 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 22, 6000),
            new Employee("张三1", 22, 4500),
            new Employee("李四", 56, 7000),
            new Employee("王五", 30, 7000),
            new Employee("王五1", 30, 8000)
    );

    @Test
    public void fun() {
        Collections.sort(employees,(e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return Integer.compare(e1.getCharge() , e2.getCharge());
            }else {
                return Integer.compare(e1.getAge() , e2.getAge());
            }

        });
        employees.forEach(System.out::println);
    }

    @Test
    public void fun2() {
        option(100L,200L,((x,y) -> x*y ));
        option(100L,200L,((x,y) -> x+y ));
    }

    public void option(Long l1 , Long l2 , MyInterface<Long , Long> mf) {
        System.out.println(mf.getVal(l1,l2));
    }
}
