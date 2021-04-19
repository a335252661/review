package A04_设计模式.A5_05_工厂模式.工厂方法;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/10
 */
public class DazhongFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Dazhong();
    }
}
