package A04_设计模式.A4_02_策略模式;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/9
 */
public class BizUnitService {
    public String bizOne(String order) {
        return order + "各种花式操作1";
    }
    public String bizTwo(String order) {
        return order + "各种花式操作2";
    }
    public String bizThree(String order) {
        return order + "各种花式操作3";
    }
}
