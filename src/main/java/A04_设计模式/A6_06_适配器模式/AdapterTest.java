package A04_设计模式.A6_06_适配器模式;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/28
 *  适配器实现接口，接口方法是对原来的类方法（及你需要调用的方法）的变化，也就是适配
 */
class Speacker{
    public String speak() {
        System.out.println("我是加密的内容");
        return "xxxxxxx";
    }
}
interface Translator{
    String translate();
}
class Adapter implements Translator{
    private Speacker speacker;
    public Adapter(Speacker speacker){
        this.speacker = speacker;
    }
    @Override
    public String translate() {
        String speak = speacker.speak();
        System.out.println("对加密内容解密");
        return "123";
    }
}
public class AdapterTest {
    public static void main(String[] args) {
        String translate = new Adapter(new Speacker()).translate();
        System.out.println(translate);
    }
}
