import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class WorkerManagerTest {
    WorkerManager manager;

    @Before
    public void setUp(){
    }

    @Test
    public void testCreateWorker(){
        manager = new WorkerManager();
        String output = manager.CreateWorker("Bob", 2000, "bakery", "Monday", "9AM", "4PM");
        String expected = "worker Bob with id 0, salary 2000 department bakery is created";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testChangeSalary() {
        manager = new WorkerManager();
        manager.CreateWorker("Bob", 1900, "bakery", "Monday", "9AM", "4PM");
        String output = manager.changeSalary(0, 0.5);
        String expected = "the salary of Bob with id 0 has been changed to 2850.0";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testChangeSchedule(){
        manager = new WorkerManager();
        manager.CreateWorker("Bob", 1900, "bakery", "Monday", "9AM", "4PM");
        String output = manager.changeSchedule(0, "Tuesday", "11AM", "9PM");
        String expected = "schedule changed for Bob with id 0 in bakery department with current schedule on Tuesday from 11AM to 9PM";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testDeleteWorker(){
        manager = new WorkerManager();
        manager.CreateWorker("Bob", 1900, "bakery", "Monday", "9AM", "4PM");
        String output = manager.deleteWorker(0);
        String expected = "worker with id 0 is deleted from system";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByName(){
        manager = new WorkerManager();
        manager.CreateWorker("Bob", 1900, "bakery", "Monday", "9AM", "4PM");
        manager.CreateWorker("Bob", 3000, "clothes", "Friday", "1AM", "10PM");
        ArrayList<String> output = manager.searchByName("Bob");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("worker Bob with id 0 in department bakery with salary 1900.0 and schedule on Monday from 9AM to 4PM");
        expected.add("worker Bob with id 1 in department clothes with salary 3000.0 and schedule on Friday from 1AM to 10PM");
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testAllWorker(){
        manager = new WorkerManager();
        manager.CreateWorker("Bob", 1900, "bakery", "Monday", "9AM", "4PM");
        manager.CreateWorker("Victor", 3000, "clothes", "Friday", "1AM", "10PM");
        ArrayList<String> output = manager.allWorker();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("worker Bob with id 0 in department bakery with salary 1900.0 and schedule on Monday from 9AM to 4PM");
        expected.add("worker Victor with id 1 in department clothes with salary 3000.0 and schedule on Friday from 1AM to 10PM");
        Assertions.assertEquals(expected, output);
    }
}