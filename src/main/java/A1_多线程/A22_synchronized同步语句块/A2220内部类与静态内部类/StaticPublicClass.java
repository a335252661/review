package A1_多线程.A22_synchronized同步语句块.A2220内部类与静态内部类;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 */
public class StaticPublicClass {
    static private String username;
    static private String password;
    static class StaticPrivateClass {
        private String age;
        private String address;
        public String getAge() {
            return age;
        }
        public void setAge(String age) {
            this.age = age;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public void printPublicProperty() {
            System.out.println(username + " " + password);
        }
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        StaticPublicClass publicClass = new StaticPublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");
        System.out.println(publicClass.getUsername() + " "
                + publicClass.getPassword());

        StaticPrivateClass privateClass = new StaticPrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " "
                + privateClass.getAddress());
    }

}
