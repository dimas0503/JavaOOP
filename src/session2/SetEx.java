package session2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dchernetskyi on 27.09.2015.
 */
public class SetEx {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        Student st1a = new Student("St1",10);
        Student st1b = new Student("St1",10);
        Student st2a = new Student("St2",10);
        Student st2b = new Student("St2",10);

        System.out.println(st1a.equals(st2a));

        set.add(st1a);
        set.add(st1b);
        set.add(st2a);
        set.add(st2b);

        System.out.println(set);
    }
}
