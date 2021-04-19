package JDK18.Lambda;

import JDK18.Lambda.Interface.MyStrategy;
import JDK18.Lambda.bean.Employee;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/26
 */
public class FilterEmployeeByAge implements MyStrategy<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>40;
    }
}
