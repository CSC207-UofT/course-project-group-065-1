import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class workerManagerTest {
    Worker w;
    WorkerManager manager;

    @Before
    public void setUp(){
        Schedule s = new Schedule("Monday", "9AM", "4PM");
        w = new Worker("Bob", 1900, 0, "food", s);
        manager = new WorkerManager();
    }

    @Test
    public void changeSalary() {
        String message = manager.changeSalary(0, 0.5);
        String [] output = {Double.toString(w.getSalary()), message};
        String [] expected = {"2850", "the salary of Bob with id 0 has been changed to 2850"};
        assertArrayEquals(expected, output);
    }
}