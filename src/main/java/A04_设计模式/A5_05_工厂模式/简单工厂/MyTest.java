package A04_设计模式.A5_05_工厂模式.简单工厂;

import org.junit.Test;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/10
 *
 * 需要的对象不需要自己创建，通过工厂获取
 * 如果我需要宝马的话，那我得去修改代码，在工厂新建，不满足开闭原则，
 */
public class MyTest {
    @Test
    public void fun() {
        Car car = CarFactory.getCar("大众");
        car.create();
    }
}
