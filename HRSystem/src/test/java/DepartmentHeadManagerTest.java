/*
When running this test, you will have to create 2 new ser files in order for this to work since we use
serializations.
 */
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
        manager = new DepartmentHeadManager(readWriter);
        String output = manager.createDepartmentHead("Bob", "bakery", 10).get(0);
        String expected = "Bob 3 bakery 10";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testDeleteHead() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter);
        String output = manager.deleteHead(0).get(0);
        String expected = "S 0";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByExperienceYear() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter);
        ArrayList<String> output = manager.searchByExperienceYear("more", 15);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Victor 1 clothes 20");
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testAllHeads() throws IOException, ClassNotFoundException {
        DepartmentHeadReadWriter readWriter = new DepartmentHeadReadWriter();
        manager = new DepartmentHeadManager(readWriter);
        manager.createDepartmentHead("Bob", "bakery", 10);
        manager.createDepartmentHead("Victor", "clothes", 20);
        manager.createDepartmentHead("Keith", "food", 3);
        ArrayList<String> output = manager.allHeads();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Bob 0 bakery 10");
        expected.add("Victor 1 clothes 20");
        expected.add("Keith 2 food 3");
        Assertions.assertEquals(expected, output);
    }
}
