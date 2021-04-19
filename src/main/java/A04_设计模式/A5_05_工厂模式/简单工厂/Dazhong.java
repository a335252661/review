package A04_设计模式.A5_05_工厂模式.简单工厂;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/10
 */
public class Dazhong implements Car{
    @Override
    public void create() {
        System.out.println("大众被创建");
    }
}
