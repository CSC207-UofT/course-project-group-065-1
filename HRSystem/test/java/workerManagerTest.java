import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class workerManagerTest {
    ArrayList<departmentHead> heads;
    worker w;
    workerManager manager;

    @Before
    public void setUp(){
        departmentHead d = new departmentHead("Jack", 0, "food");
        heads = new ArrayList<>();
        heads.add(d);
        schedule s = new schedule("Monday", "9AM", "4PM");
        w = new worker("Bob", 1900, 0, "food", s);
        manager = new workerManager();
    }

    @Test
    public void changeSalary() {
        String message = manager.changeSalary(0, 0, heads, 0.5);
        String [] output = {Double.toString(w.getSalary()), message};
        String [] expected = {"2850", "the salary of Bob with id 0 has been changed to 2850 by permission from Jack"};
        assertArrayEquals(expected, output);
    }
}