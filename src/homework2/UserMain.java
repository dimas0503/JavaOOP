package homework2;

import java.util.Date;

/**
 * Created by Dima on 10.10.2015.
 */
public class UserMain {
    public static void main(String[] args) {

        Date date = new Date();
        date.setMonth(10);
        date.setYear(2015);
        date.setDate(10);
        System.out.println(date);

        User u1 = new User("u1","p1", date, 10.0, "M");
        User u2 = new User("u1","p1", date, 10.0, "M");

        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());

        System.out.println(u1.equals(u2));
    }
}
