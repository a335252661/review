package A1_JUC练习.A1_01_集合类不安全问题;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/22
 */
public class CollectionNotSafeDemo {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new CopyOnWriteArrayList<>();

        Set<String> list = new HashSet<>();
//        Set<String> list = Collections.synchronizedSet( new HashSet<>());
//        Set<String> list = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(list);
                }
            },"线程"+i).start();
        }
    }
    //出现异常  java.util.ConcurrentModificationException   并发修改异常

}
