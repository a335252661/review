package A1_多线程.A22synchronized同步语句块.A2220内部类与静态内部类;

import lombok.Data;

/**
 * @author 程刘德
 * @version 1.0
 * @Description TODO
 * @date 2020/7/22
 */
@Data
public class PublicClass {
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

    private String username;
    private String password;

    @Data
    class PrivateClass {
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

        private String age;
        private String address;
        public void printPublicProperty() {
            System.out.println(username + " " + password);
        }
    }
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");
        System.out.println(publicClass.getUsername() + " "
                + publicClass.getPassword());


        PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " "
                + privateClass.getAddress());
    }
}
