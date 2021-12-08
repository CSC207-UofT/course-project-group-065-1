import DepartmentHeadOperations.DepartmentHeadManager;
import Data.DepartmentHeadReadWriter;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

public class DepartmentHeadManagerTest {

    DepartmentHeadManager manager;

    @Before
    public void setUp(){
    }

    @Test
    public void testCreateDepartmentHead() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        String output = manager.createDepartmentHead("Bob", "bakery", 10, true).get(0);
        String expected = "Bob 0 bakery 10";
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testDeleteHead() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        String output = manager.deleteHead(0, true).get(1);
        String expected = "S Bob 0 bakery 10";
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testDeleteHeadNull() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        String output = manager.deleteHead(1, true).get(0);
        String expected = "N I";
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByExperienceYear() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        manager.createDepartmentHead("Victor", "clothes", 20, true);
        manager.createDepartmentHead("Keith", "food", 3, true);
        ArrayList<String> output = manager.searchByExperienceYear(15);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Victor 1 clothes 20");
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByExperienceYearNull() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        manager.createDepartmentHead("Victor", "clothes", 20, true);
        manager.createDepartmentHead("Keith", "food", 3, true);
        ArrayList<String> output = manager.searchByExperienceYear(21);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("F");
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByID() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        manager.createDepartmentHead("Victor", "clothes", 20, true);
        manager.createDepartmentHead("Keith", "food", 3, true);
        ArrayList<String> output = manager.searchByID(1);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Victor 1 clothes 20");
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByIDNull() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        manager.createDepartmentHead("Victor", "clothes", 20, true);
        manager.createDepartmentHead("Keith", "food", 3, true);
        ArrayList<String> output = manager.searchByID(5);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("f");
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testAllHeads() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        manager.createDepartmentHead("Victor", "clothes", 20, true);
        manager.createDepartmentHead("Keith", "food", 3, true);
        ArrayList<String> output = manager.allHeads();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Bob 0 bakery 10");
        expected.add("Victor 1 clothes 20");
        expected.add("Keith 2 food 3");
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testUndoCreateDepartmentHead() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        manager.createDepartmentHead("Victor", "clothes", 20, true);
        manager.createDepartmentHead("Keith", "food", 3, true);
        manager.undoCreateDepartmentHead(true);
        ArrayList<String> output = manager.allHeads();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Bob 0 bakery 10");
        expected.add("Victor 1 clothes 20");
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testUndoDeleteHead() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter, true);
        manager.createDepartmentHead("Bob", "bakery", 10, true);
        manager.deleteHead(0, true);
        ArrayList<String> argument = new ArrayList<>(List.of("Bob", "0", "bakery", "10"));
        manager.undoDeleteHead(argument, true);
        ArrayList<String> output = manager.allHeads();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Bob 0 bakery 10");
        manager.deleteAllHead(true);
        Assertions.assertEquals(expected, output);
    }



}
