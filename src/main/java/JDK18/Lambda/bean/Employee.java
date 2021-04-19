package JDK18.Lambda.bean;

import lombok.Data;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 */
@Data
public class Employee {
    String name;
    int age;
    int charge;

    public Employee(String name, int age, int charge) {
        this.name = name;
        this.age = age;
        this.charge = charge;
    }

}
