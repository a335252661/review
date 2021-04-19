package A0_java基础.A06_枚举类;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2021/3/11
 */
public enum AccountType {
    SAVING,
    FIXED,
    CURRENT;
    private AccountType() {
        System.out.println("It is a account type");
    }
    public static void main(String[] args) {
        System.out.println(AccountType.FIXED);
    }
}
