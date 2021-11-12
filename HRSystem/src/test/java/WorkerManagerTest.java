/*
When running this test, you will have to create 2 new ser files in order for this to work since we use
serializations.
 */
import WorkerCommands.WorkerManager;
import Data.WorkerReadWriter;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

public class WorkerManagerTest {
    WorkerManager manager;

    @Before
    public void setUp(){
    }

    @Test
    public void testCreateWorker() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        String output = manager.createWorker("Bob", 2000, "bakery", "Monday", "9AM", "4PM").get(0);
        String expected = "worker Bob with id 0, salary 2000 department bakery is created";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testChangeSalary() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        String output = manager.changeSalary(0, 0.5).get(0);
        String expected = "the given worker ID doesn't match with an ID in the system";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testChangeSchedule() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        String output = manager.changeSchedule(1, "Tuesday", "11AM", "9PM").get(0);
        String expected = "schedule changed for Bob with id 1 in bakery department with current schedule on Tuesday from 11AM to 9PM";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testDeleteWorker() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        String output = manager.deleteWorker(0).get(0);
        String expected = "worker with id 0 is deleted from system";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByName() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        manager.createWorker("Bob", 3000, "clothes", "Friday", "1AM", "10PM");
        ArrayList<String> output = manager.searchByName("Bob");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("worker Bob with id 1 in department bakery with salary 1900.0 and schedule on Monday from 9AM to 4PM");
        expected.add("worker Bob with id 3 in department clothes with salary 3000.0 and schedule on Friday from 1AM to 10PM");
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testAllWorker() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        manager.createWorker("Bob", 1900, "bakery", "Monday", "9AM", "4PM");
        manager.createWorker("Victor", 3000, "clothes", "Friday", "1AM", "10PM");
        ArrayList<String> output = manager.allWorker();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("worker Bob with id 0 in department bakery with salary 2000.0 and schedule on Monday from 9AM to 4PM");
        expected.add("worker Bob with id 1 in department bakery with salary 1900.0 and schedule on Monday from 9AM to 4PM");
        expected.add("worker Victor with id 2 in department clothes with salary 3000.0 and schedule on Friday from 1AM to 10PM");
        Assertions.assertEquals(expected, output);
    }
}