package A04_设计模式.A4_03_观察者模式;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/9
 */
public class User implements Observer{
    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void getMsg(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }

}
