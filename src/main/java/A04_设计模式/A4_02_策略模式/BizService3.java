package A04_设计模式.A4_02_策略模式;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/9
 */
public class BizService3 {
    /**
     * 业务逻辑分派Map
     * Function为函数式接口，下面代码中 Function<String, String> 的含义是接收一个Stirng类型的变量，返回一个String类型的结果
     */
    private Map<String, Function<String, String>> checkResultDispatcherMuti = new HashMap<>();

    public void checkResultDispatcherMuitInit() {
        checkResultDispatcherMuti.put("key_订单1", order -> String.format("对%s执行业务逻辑1", order));
        checkResultDispatcherMuti.put("key_订单1_订单2", order -> String.format("对%s执行业务逻辑2", order));
        checkResultDispatcherMuti.put("key_订单1_订单2_订单3", order -> String.format("对%s执行业务逻辑3", order));
    }

    public void checkResultDispatcherMuitInit2() {
        BizUnitService bizUnitService = new BizUnitService();
        checkResultDispatcherMuti.put("key_订单1", order -> bizUnitService.bizOne(order));
        checkResultDispatcherMuti.put("key_订单1_订单2", order -> bizUnitService.bizTwo(order));
        checkResultDispatcherMuti.put("key_订单1_订单2_订单3", order -> bizUnitService.bizThree(order));
    }

    public String getCheckResultMuti(String order, int level) {
        //写一段生成key的逻辑：
        String ley = getDispatcherKey(order, level);
        new BizService3().checkResultDispatcherMuitInit();
        Function<String, String> result = checkResultDispatcherMuti.get(ley);
        if (result != null) {
            //执行这段表达式获得String类型的结果
            return result.apply(order);
        }
        return "不在处理的逻辑中返回业务错误";
    }
    /**
     * 判断条件方法
     */
    private String getDispatcherKey(String order, int level) {
        StringBuilder key = new StringBuilder("key");
        for (int i = 1; i <= level; i++) {
            key.append("_" + order + i);
        }
        return key.toString();
    }
    public static void main(String[] args) {
        BizService3 bizService2 = new BizService3();
        String result = bizService2.getCheckResultMuti("订单",2);
        System.out.println(result);
    }

}
