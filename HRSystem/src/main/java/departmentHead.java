import java.util.*;
public class departmentHead extends employees{
    ArrayList<worker> workerInDepart;

    /**
     * constructor for department head. Initialize the worker under the department head arraylist to empty (no worker)
     * @param name the name of the department head
     * @param ID the ID of the department head
     * @param department the department of the department head
     */
    public departmentHead(String name, int ID, String department) {
        super(name, ID, department);
        workerInDepart = new ArrayList<>();
    }

    /**
     * get the list of all workers under the department
     * @return the list of all workers under its department
     */
    public ArrayList<worker> getWorkerInDepart() {
        return this.workerInDepart;
    }

    /**
     * set the list of all workers under the department to the given arraylist
     * @param workers the target list of worker
     */
    public void setWorkerInDepart(ArrayList<worker> workers){
        this.workerInDepart = workers;
    }
}
