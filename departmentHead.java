import java.util.*;
public class departmentHead extends employees{
    ArrayList<worker> workerInDepart;

    public departmentHead(String name, int ID, String department) {
        super(name, ID, department);
        workerInDepart = new ArrayList<>();
    }

    public ArrayList<worker> getWorkerInDepart() {
        return this.workerInDepart;
    }

    public void setWorkerInDepart(ArrayList<worker> workers){
        this.workerInDepart = workers;
    }
}
