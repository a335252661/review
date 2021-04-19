package A06_核心.A01_集合.Map.ConcurrentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/28
 */
public class Demo01 {
    public static void main(String[] args) {
        Map<String , String> map = new ConcurrentHashMap<>();
        map.put("a","1");
    }
}
