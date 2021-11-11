import DepartmentHeadCommands.DepartmentHeadManager;
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
    public void testCreateDepartmentHead() throws IOException {
        manager = new DepartmentHeadManager();
        String output = manager.createDepartmentHead("Bob", "bakery", 10).get(0);
        String expected = "department head Bob with id 0, department bakery and 10 years of experience is created";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testDeleteHead() throws IOException {
        manager = new DepartmentHeadManager();
        manager.createDepartmentHead("Bob", "bakery", 10);
        String output = manager.deleteHead(0).get(0);
        String expected = "department head with id 0 is deleted from the system";
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testSearchByExperienceYear() throws IOException {
        manager = new DepartmentHeadManager();
        manager.createDepartmentHead("Bob", "bakery", 10);
        manager.createDepartmentHead("Victor", "clothes", 20);
        ArrayList<String> output = manager.searchByExperienceYear("more", 15);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("department head Victor with ID 1 in department clothes with 20 years of experience");
        Assertions.assertEquals(expected, output);
    }

    @Test
    public void testAllHeads() throws IOException {
        manager = new DepartmentHeadManager();
        manager.createDepartmentHead("Bob", "bakery", 10);
        manager.createDepartmentHead("Victor", "clothes", 20);
        manager.createDepartmentHead("Keith", "food", 3);
        ArrayList<String> output = manager.allHeads();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("department head Bob with ID 0 in department bakery with 10 years of experience");
        expected.add("department head Victor with ID 1 in department clothes with 20 years of experience");
        expected.add("department head Keith with ID 2 in department food with 3 years of experience");
        Assertions.assertEquals(expected, output);
    }
}
