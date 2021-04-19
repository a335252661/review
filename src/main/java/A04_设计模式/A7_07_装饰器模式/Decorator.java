package A04_设计模式.A7_07_装饰器模式;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/28
 */
interface Robot{
    void dosomething();
}
class FirstRobot implements Robot{
    @Override
    public void dosomething() {
        System.out.println("对话");
        System.out.println("唱歌");
    }
}
//abstract class RobotDecorator implements Robot{
 class RobotDecorator implements Robot{
    private Robot robot;
    public RobotDecorator(Robot robot){ this.robot = robot; }
    @Override
    public void dosomething() { robot.dosomething(); }
    public void doMoreSomething() { robot.dosomething();System.out.println("跳舞"); }
}
public class Decorator {
    public static void main(String[] args) {
        new RobotDecorator(new FirstRobot()).doMoreSomething();
    }
}
