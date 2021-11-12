import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Entities.*;
public class TestEntities {
    @Before
    public void setUp(){
    }

    @Test
    public void testWorkerGetName(){
        Worker w = new Worker("Bob", 1900, 0, "bakery", new Schedule("Monday", "11AM", "4PM"));
        Assertions.assertEquals("Bob", w.getName());
    }

    @Test
    public void testWorkerGetSalary(){
        Worker w = new Worker("Bob", 1900, 0, "bakery", new Schedule("Monday", "11AM", "4PM"));
        Assertions.assertEquals(1900.0, w.getSalary());
    }

    @Test
    public void testWorkerGetID(){
        Worker w = new Worker("Bob", 1900, 0, "bakery", new Schedule("Monday", "11AM", "4PM"));
        Assertions.assertEquals(0, w.getID());
    }

    @Test
    public void testWorkerGetDepartment(){
        Worker w = new Worker("Bob", 1900, 0, "bakery", new Schedule("Monday", "11AM", "4PM"));
        Assertions.assertEquals("bakery", w.getDepartment());
    }

    @Test
    public void testWorkerGetSchedule(){
        Schedule s = new Schedule("Monday", "11AM", "4PM");
        Worker w = new Worker("Bob", 1900, 0, "bakery", s);
        Assertions.assertEquals(s, w.getSchedule());
    }

    @Test
    public void testWorkerSetSalary(){
        Worker w = new Worker("Bob", 1900, 0, "bakery", new Schedule("Monday", "11AM", "4PM"));
        w.setSalary(2000.0);
        Assertions.assertEquals(2000.0, w.getSalary());
    }

    @Test
    public void testWorkerSetSchedule(){
        Worker w = new Worker("Bob", 1900, 0, "bakery", new Schedule("Monday", "11AM", "4PM"));
        Schedule s = new Schedule("Friday", "9AM", "10PM");
        w.setSchedule("Friday", "9AM", "10PM");
        Assertions.assertEquals(s.toString(), w.getSchedule().toString());
    }

    @Test
    public void testWorkerToString(){
        Worker w = new Worker("Bob", 1900, 0, "bakery", new Schedule("Monday", "11AM", "4PM"));
        Assertions.assertEquals("worker Bob with id 0 in department bakery with salary 1900.0 and schedule on Monday from 11AM to 4PM", w.toString());
    }

    @Test
    public void testHeadGetName(){
        DepartmentHead h = new DepartmentHead("Bob", 0, "bakery", 5);
        Assertions.assertEquals("Bob", h.getName());
    }

    @Test
    public void testHeadGetID(){
        DepartmentHead h = new DepartmentHead("Bob", 0, "bakery", 5);
        Assertions.assertEquals(0, h.getID());
    }

    @Test
    public void testHeadGetDepartment(){
        DepartmentHead h = new DepartmentHead("Bob", 0, "bakery", 5);
        Assertions.assertEquals("bakery", h.getDepartment());
    }

    @Test
    public void testHeadGetYearExperience(){
        DepartmentHead h = new DepartmentHead("Bob", 0, "bakery", 5);
        Assertions.assertEquals(5, h.getYearOfExperience());
    }

    @Test
    public void testHeadToString(){
        DepartmentHead h = new DepartmentHead("Bob", 0, "bakery", 5);
        Assertions.assertEquals("department head Bob with ID 0 in department bakery with 5 years of experience", h.toString());
    }

    @Test
    public void testScheduleSetDayOfWeek(){
        Schedule s = new Schedule("monday", "11AM", "9PM");
        s.setDayOfWeek("Tuesday");
        Assertions.assertEquals("Tuesday from 11AM to 9PM", s.toString());
    }

    @Test
    public void testScheduleSetStartTime(){
        Schedule s = new Schedule("monday", "11AM", "9PM");
        s.setStartTime("10AM");
        Assertions.assertEquals("monday from 10AM to 9PM", s.toString());
    }

    @Test
    public void testScheduleSetEndTime(){
        Schedule s = new Schedule("monday", "11AM", "9PM");
        s.setEndTime("10PM");
        Assertions.assertEquals("monday from 11AM to 10PM", s.toString());
    }

    @Test
    public void testScheduleToString(){
        Schedule s = new Schedule("monday", "11AM", "9PM");
        Assertions.assertEquals("monday from 11AM to 9PM", s.toString());
    }
}
