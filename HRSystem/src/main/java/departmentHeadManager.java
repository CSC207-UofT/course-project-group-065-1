import java.util.ArrayList;
import java.util.HashMap;

public class departmentHeadManager {
    /**
     * create a new department head
     * @param heads list of all department heads created
     * @param name the name of the department head
     * @param id the ID of the department head
     * @param department the department of the department head
     * @return a map where the integer 0 means not change the next department head ID and a
     * list of all department head and 1 means increase the next department head ID by 1 and
     * set the list of all department head to the list in the value of the map
     */
    public HashMap<Integer, ArrayList<departmentHead>> createDepartmentHead(ArrayList<departmentHead> heads, String name, int id, String department){
        HashMap<Integer, ArrayList<departmentHead>> map = new HashMap<>();
        for(departmentHead head : heads){
            if(head.getDepartment().equals(department)){//check if there is already a department head for the given department
                map.put(0, heads);// if so, then return 0 as key since no new department head is created
                return map;
            }
        }
        departmentHead newHead = new departmentHead(name, id, department);// if not, then create a new department head
        heads.add(newHead);
        map.put(1, heads);// return the map that signal the next department head ID and the list of all department head should be changed
        return map;
    }
}
