package homework2;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Dima on 10.10.2015.
 */
public class UserTest {

    @Before
    public void setUp(){
        Date date = new Date();
        date.setMonth(10);
        date.setYear(2015);
        date.setDate(10);

        User module = new User("u1","p1", date, 10.0, "M");
    }

    @Test
    public void testHashCode() throws Exception {

        Date date = new Date();
        date.setMonth(10);
        date.setYear(2015);
        date.setDate(10);

        User module = new User("u1","p1", date, 10.0, "M");

        int expected = 7284;
        assertEquals(expected,module.hashCode());
    }

    @Test
    public void testEquals() throws Exception {

        Date date = new Date();
        date.setMonth(10);
        date.setYear(2015);
        date.setDate(10);

        User expected = new User("u1","p1", date, 10.0, "M");
        User result = new User("u1","p1", date, 10.0, "M");

        assertEquals(expected,result);

    }
}