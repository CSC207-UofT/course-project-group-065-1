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
        manager = new WorkerManager(readWriter, true);
        ArrayList<String> arguments = new ArrayList<>(List.of("Bob", "2000", "bakery", "Monday", "9AM", "4PM"));
        String output = manager.createWorker(arguments, true).get(0);
        String expected = "Bob 0 2000 bakery";
        manager.deleteAllWorker(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testChangeSalary() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter, true);
        String output = manager.changeSalary(0, 0.5, true).get(0);
        String expected = "N I";
        manager.deleteAllWorker(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testChangeSchedule() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter, true);
        ArrayList<String> WorkerArguments = new ArrayList<>(List.of("Bob", "2000", "bakery", "Monday", "9AM", "4PM"));
        manager.createWorker(WorkerArguments, true);
        ArrayList<String> arguments = new ArrayList<>(List.of("0", "Tuesday", "11AM", "9PM"));
        String output = manager.changeSchedule(arguments, true).get(0);
        String expected = "S Bob 0 bakery Tuesday from 11AM to 9PM";
        manager.deleteAllWorker(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testDeleteWorker() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter, true);
        ArrayList<String> arguments = new ArrayList<>(List.of("Bob", "2000", "bakery", "Monday", "9AM", "4PM"));
        manager.createWorker(arguments, true);
        String output = manager.deleteWorker(0, true).get(0);
        String expected = "S Bob 0 bakery 2000.0 Monday from 9AM to 4PM";
        manager.deleteAllWorker(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByName() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter, true);
        ArrayList<String> arguments1 = new ArrayList<>(List.of("Bob", "3000", "clothes", "Friday", "1AM", "10PM"));
        manager.createWorker(arguments1, true);
        ArrayList<String> arguments2 = new ArrayList<>(List.of("Bob", "5000", "clothes", "Friday", "3AM", "6PM"));
        manager.createWorker(arguments2, true);
        ArrayList<String> output = manager.searchByName("Bob");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Bob 0 clothes 3000.0 Friday from 1AM to 10PM");
        expected.add("Bob 1 clothes 5000.0 Friday from 3AM to 6PM");
        manager.deleteAllWorker(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testAllWorker() throws IOException, ClassNotFoundException {
        WorkerReadWriter readWriter = new WorkerReadWriter();
        manager = new WorkerManager(readWriter, true);
        ArrayList<String> arguments1 = new ArrayList<>(List.of("Bob", "1900", "bakery", "Monday", "9AM", "4PM"));
        manager.createWorker(arguments1, true);
        ArrayList<String> arguments2 = new ArrayList<>(List.of("Victor", "3000", "clothes", "Friday", "1AM", "10PM"));
        manager.createWorker(arguments2, true);
        ArrayList<String> output = manager.allWorker();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Bob 0 bakery 1900.0 Monday from 9AM to 4PM");
        expected.add("Victor 1 clothes 3000.0 Friday from 1AM to 10PM");
        manager.deleteAllWorker(true);
        Assertions.assertEquals(expected, output);
    }
}