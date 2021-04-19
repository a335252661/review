package A04_设计模式.A4_03_观察者模式;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/9
 *
 * 观察者模式，
 * 就好像发布订阅模式 ， rabbitmq  广播
 * 订阅者user（这个用户实例）-- >  把他们总的管理起来 ， 弄一个接口   user  implements  Observer
 * 订阅者向发布者 WechatServer 订阅，把自己的信息给发布者，发布者使用个集合存起来。 发布者应该有，注册，取消注册，发布消息的方法
 * 此时订阅者发布消息，就遍历集合中订阅者，拿到订阅者对象，发消息
 *
 */
public class Test {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

    }
}
