import java.util.*;
public class HRSystem {
    ArrayList<departmentHead> departmentHeads;
    int nextWorkerID;
    int nextHeadID;

    /**
     * the constructor of the HRSystem by initialize the list of all department head to empty and
     * the next head and department head ID to 0
     */
    public HRSystem(){
        departmentHeads = new ArrayList<>();
        nextHeadID = 0;
        nextWorkerID = 0;
    }

    /**
     * run the system
     */
    public void run(){
        System.out.println("Welcome to the HR System");
        InOutHandler inOut = new InOutHandler();// define a InOutHandler which takes in user input and call method and display message
        HashMap<Integer, ArrayList<departmentHead>> operation;
        do{// repeated running the InOutHandler while the map returned doesn't have a key of -1
            System.out.println("Please enter what you want to do");
            operation = inOut.run(departmentHeads, nextWorkerID, nextHeadID);
            if(operation.containsKey(1)){// if the key is 1, then look into the arraylist and if it is 0, do nothing
                if(operation.get(1).isEmpty()){// if the list is empty, then increase worker ID by 1 (new worker created)
                    nextWorkerID++;
                }else{// otherwise, set the list of all department head to the list and increase next department head ID by 1 (new department head created)
                    departmentHeads = operation.get(1);
                    nextHeadID++;
                }
            }
        }while(!operation.containsKey(-1));
        System.out.println("Thanks for using HR System");
    }
}
