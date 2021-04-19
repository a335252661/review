package A0_java基础.A02_方法值传递和引用传递;

import lombok.Data;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/12/27
 */
@Data
public class UserVo {
    private String name;
    private String phone;

    public UserVo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
