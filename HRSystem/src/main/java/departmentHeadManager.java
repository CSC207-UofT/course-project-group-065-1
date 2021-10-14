import java.util.ArrayList;
import java.util.HashMap;

public class departmentHeadManager {
    public HashMap<Integer, ArrayList<departmentHead>> createDepartmentHead(ArrayList<departmentHead> heads, String name, int id, String department){
        HashMap<Integer, ArrayList<departmentHead>> map = new HashMap<>();
        for(departmentHead head : heads){
            if(head.getDepartment().equals(department)){
                map.put(0, heads);
                return map;
            }
        }
        departmentHead newHead = new departmentHead(name, id, department);
        heads.add(newHead);
        map.put(1, heads);
        return map;
    }
}
