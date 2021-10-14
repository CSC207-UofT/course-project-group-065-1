import java.util.*;
public class HRSystem {
    ArrayList<departmentHead> departmentHeads;
    int nextWorkerID;
    int nextHeadID;

    public HRSystem(){
        departmentHeads = new ArrayList<>();
        nextHeadID = 0;
        nextWorkerID = 0;
    }

    public void run(){
        System.out.println("Welcome to the HR System");
        InOutHandler inOut = new InOutHandler();
        HashMap<Integer, ArrayList<departmentHead>> operation;
        do{
            System.out.println("Please enter what you want to do");
            operation = inOut.run(departmentHeads, nextWorkerID, nextHeadID);
            if(operation.containsKey(1)){
                if(operation.get(1).isEmpty()){
                    nextWorkerID++;
                }else{
                    departmentHeads = operation.get(1);
                    nextHeadID++;
                }
            }
        }while(!operation.containsKey(-1));
        System.out.println("Thanks for using HR System");
    }
}
