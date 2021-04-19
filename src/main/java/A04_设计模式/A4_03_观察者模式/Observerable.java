package A04_设计模式.A4_03_观察者模式;


/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/9
 */
public interface Observerable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
