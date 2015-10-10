package homework2;

import java.util.Date;

/**
 * Created by Dima on 10.10.2015.
 */
public class User {
    private String login;
    private String password;
    private Date regDate;
    private double rate;
    private String sex;

    public User() {
    }

    public User(String login, String password, Date regDate, double rate, String sex) {
        this.login = login;
        this.password = password;
        this.regDate = regDate;
        this.rate = rate;
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return login.hashCode() + password.hashCode() + (int)rate + sex.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        User user1 = (User) obj;
        return hashCode() == user1.hashCode();
    }
}
