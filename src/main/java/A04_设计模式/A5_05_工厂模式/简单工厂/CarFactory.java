package A04_设计模式.A5_05_工厂模式.简单工厂;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/10
 */
public class CarFactory {

    public static Car getCar(String carname) {
        if("大众".equals(carname)){
            return new Dazhong();
        }

        return null;
    }

}
