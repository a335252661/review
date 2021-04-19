package A04_设计模式.A4_02_策略模式;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/9
 *
 * 策略模式：
 *  根据不同的key ， 找到不同的业务逻辑
 *  接口+实现类+分派逻辑
 *
 */
public class BizService {
    /**
     * 传统的 if else 解决方法
     * 当每个业务逻辑有 3 4 行时，用传统的策略模式不值得，直接的if else又显得不易读
     */
    public String getCheckResult(String order) {
        if ("校验1".equals(order)) {
            return "执行业务逻辑1";
        } else if ("校验2".equals(order)) {
            return "执行业务逻辑2";
        }else if ("校验3".equals(order)) {
            return "执行业务逻辑3";
        }else if ("校验4".equals(order)) {
            return "执行业务逻辑4";
        }else if ("校验5".equals(order)) {
            return "执行业务逻辑5";
        }else if ("校验6".equals(order)) {
            return "执行业务逻辑6";
        }else if ("校验7".equals(order)) {
            return "执行业务逻辑7";
        }else if ("校验8".equals(order)) {
            return "执行业务逻辑8";
        }else if ("校验9".equals(order)) {
            return "执行业务逻辑9";
        }
        return "不在处理的逻辑中返回业务错误";
    }
}
