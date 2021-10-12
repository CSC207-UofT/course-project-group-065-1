import java.util.*;
public class InOutHandler {
    Scanner in;

    public InOutHandler(){
        in = new Scanner(System.in);
    }

    public void run(ArrayList<worker> workers, ArrayList<departmentHead> departmentHeads, int nextWorkerID, int nextHeadID){
        String input = in.nextLine();
        String [] split = input.split(" ");
        if(split[0].equals("create")){
            if(split[1].equals("worker")){
                workerManager manager = new workerManager();
                workers.add(manager.createWorker(split[2], Integer.parseInt(split[3]), nextWorkerID, split[4], split[5], split[6], split[7]));
            }else if(split[1].equals("")){

            }
        }
        if(split[0].equals("create")&&split[1].equals("worker")){
            workerManager manager = new workerManager();
            workers.add(manager.createWorker(split[2], Integer.parseInt(split[3]), nextWorkerID, split[4], split[5], split[6], split[7]));
        }else if(split[0].equals("create")&&split[1].equals("department")){
            departmentHeadManager manager = new departmentHeadManager();
            departmentHeads.add(manager.createDepartmentHead(split[2], nextHeadID, split[3]));
        }else if(split[0].equals("increase")){
            
        }else if(split[0].equals("decrease")){

        }else if(split[0].equals("change")){

        }else{
            System.out.println("invalid input");
        }
    }
}
