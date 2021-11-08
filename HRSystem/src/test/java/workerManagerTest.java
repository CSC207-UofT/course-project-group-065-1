import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class workerManagerTest {
    WorkerManager manager;

    @Before
    public void setUp(){
    }

    @Test
    public void changeSalary() {
        manager = new WorkerManager();
        manager.CreateWorker("Bob", 1900, "bakery", "Monday", "9AM", "4PM");
        String output = manager.changeSalary(0, 0.5);
        String expected = "the salary of Bob with id 0 has been changed to 2850.0";
        Assertions.assertEquals(expected, output);
    }
}