/*
When running this test, you will have to create 2 new ser files in order for this to work since we use
serializations.
 */
import WorkerOperations.WorkerManager;
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
        ArrayList<String> arguments = new ArrayList<>(List.of("Bob", "2000", "bakery", "Monday", "9AM", "4PM"));
        String output = manager.createWorker(arguments).get(0);
        String expected = "Bob 0 2000 bakery";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testChangeSalary() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        String output = manager.changeSalary(0, 0.5).get(0);
        String expected = "N I";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testChangeSchedule() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        ArrayList<String> arguments = new ArrayList<>(List.of("1", "Tuesday", "11AM", "9PM"));
        String output = manager.changeSchedule(arguments).get(0);
        String expected = "S Bob 1 bakery Tuesday from 11AM to 9PM";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testDeleteWorker() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        String output = manager.deleteWorker(0).get(0);
        String expected = "S 0";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByName() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        ArrayList<String> arguments = new ArrayList<>(List.of("Bob", "3000", "clothes", "Friday", "1AM", "10PM"));
        manager.createWorker(arguments);
        ArrayList<String> output = manager.searchByName("Bob");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Bob 1 bakery 1900.0 Monday from 9AM to 4PM");
        expected.add("Bob 3 clothes 3000.0 Friday from 1AM to 10PM");
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testAllWorker() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter);
        ArrayList<String> arguments1 = new ArrayList<>(List.of("Bob", "1900", "bakery", "Monday", "9AM", "4PM"));
        manager.createWorker(arguments1);
        ArrayList<String> arguments2 = new ArrayList<>(List.of("Victor", "3000", "clothes", "Friday", "1AM", "10PM"));
        manager.createWorker(arguments2);
        ArrayList<String> output = manager.allWorker();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Bob 0 bakery 2000.0 Monday from 9AM to 4PM");
        expected.add("Bob 1 bakery 1900.0 Monday from 9AM to 4PM");
        expected.add("Victor 2 clothes 3000.0 Friday from 1AM to 10PM");
        Assertions.assertEquals(expected, output);
    }
}