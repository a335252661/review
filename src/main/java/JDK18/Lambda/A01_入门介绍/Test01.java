package JDK18.Lambda.A01_入门介绍;

import JDK18.Lambda.FilterEmployeeByAge;
import JDK18.Lambda.FilterEmployeeByCharge;
import JDK18.Lambda.Interface.MyStrategy;
import JDK18.Lambda.bean.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 */
public class Test01 {

    //定义一个接口
    public  interface  Printer{
        void myprinter(String val);
    }

    class Children  implements Printer{
        @Override
        public void myprinter(String val) {
            System.out.println(val);
        }
    }


    @Test
    public void fun() {
        Test01 test = new Test01();


        //使用实现类调用
        Children children = new Children();
        test.pringSome("我是需要打印的" , children);


        //使用实现类调用 , 接口的引用指向实现类的对象  p2 就是实现类对象
        Printer p2 = new Children();
        test.pringSome("我是需要打印的" , p2);


        //new一个接口，重写抽象方法 ， 接口的引用指向匿名实现类，pp就是实现类对象
        Printer pp = new Printer() {
            @Override
            public void myprinter(String val) {
                System.out.println(val);
            }
        };

        //之前普通调用
        test.pringSome("我是需要打印的" , pp);



        //lambda表达式调用  lambda表达式 表达的就是 接口的匿名实现类  接口的引用指向匿名实现类，接口中必须只有一个抽象方法
        Printer p1 = e -> { System.out.println(e); };
        test.pringSome("我是需要打印的",p1);



    }

    public void pringSome(String val , Printer pp) {
        pp.myprinter(val);
    }


    public static void main(String[] args) {
        Test01 test = new Test01();


        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet treeSet = new TreeSet(com);

        //Lambda
        Comparator<Integer> com2 = (a,b) -> Integer.compare(a,b);
        System.out.println(1);

        List<Employee> employees = Arrays.asList(
                new Employee("张三", 22, 6000),
                new Employee("李四", 56, 7000),
                new Employee("王五", 30, 8000)
        );


        //策略设计模式，给他什么策略就按照什么策略过滤
        //按照年龄过滤
        List<Employee> employees1 = test.filterEmployee(employees, new FilterEmployeeByAge());
        employees1.forEach(System.out::println);


        //按照工资过滤
        System.out.println("按照工资过滤");
        List<Employee> employees2 = test.filterEmployee(employees, new FilterEmployeeByCharge());
        employees2.forEach(System.out::println);

        //匿名内部类方式优化策略模式
        System.out.println("匿名内部类方式优化策略模式");
        List<Employee> employees3 = test.filterEmployee(employees, new MyStrategy<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 50;
            }
        });
        employees3.forEach(System.out::println);

        //lambda表达式写法
        System.out.println("lambda表达式写法");
        List<Employee> employees4 = test.filterEmployee(employees, e -> e.getAge() > 50);
        employees4.forEach(System.out::println);

        //stream方式
        System.out.println("stream方式");
        Stream<Employee> employeeStream = employees.stream().filter(e -> e.getAge() > 50);
        employeeStream.forEach(System.out::println);

        //stream方式 加条件
        System.out.println("stream方式 加条件");
        employees.stream()
                .filter(e -> e.getCharge() > 30)
                .limit(2)
                .forEach(System.out::println);


    }

    public List<Employee> filterEmployee(List<Employee> employees , MyStrategy<Employee> myStrategy) {
        List<Employee> employeesnew  = new ArrayList<>();
        for(Employee em :employees){
            if(myStrategy.test(em)){
                employeesnew.add(em);
            }
        }
        return employeesnew;
    }

}
