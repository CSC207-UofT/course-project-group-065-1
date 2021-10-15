import java.util.*;
public class InOutHandler {
    /*
    handles input
    only focuses on relevant input, extra content at end will be ignored
     */
    Scanner in;

    /**
     * constructor of InOutHandler by initialize a scanner
     */
    public InOutHandler(){
        in = new Scanner(System.in);
    }

    /**
     * take in the user input and call corresponding use case method and display the message
     * @param heads list of all department heads
     * @param nextWorkerID the next avaliable worker
     * @param nextHeadID the next avaliable department head
     * @return a map where 0 means not change list of all department head and next worker and department head ID and
     * 1 with an empty list means increase the next worker ID by 1 and 1 with a non-empty list mean increase department
     * head ID by 1 and set the list of all department head to the non-empty list
     */
    public HashMap<Integer, ArrayList<departmentHead>> run(ArrayList<departmentHead> heads, int nextWorkerID, int nextHeadID) {
        String input = in.nextLine();
        String [] split = input.split(" ");// take in input and split them by space
        HashMap<Integer, ArrayList<departmentHead>> map = new HashMap<>();
        switch(split[0]){// break into different cases based on the first words of the user's input
            case "create":
                if(split[1].equals("worker")){// if the user want to create worker, then call the create worker method and display message based on the map returned
                    workerManager manager = new workerManager();
                    map = manager.createWorker(heads, split[2], Integer.parseInt(split[3]), nextWorkerID, split[4], split[5], split[6], split[7]);
                    if(map.containsKey(0)){
                        System.out.println("no department head for the department");
                    }else{
                        System.out.println("worker " + split[2] + " Bob with id " + nextWorkerID + ", salary " + split[3] + " and department " + split[4] + " is created");
                    }
                    return map;
                }else if(split[1].equals("department")){// if the user want to create department head, then call the create department head method and display message based on the map returned
                    departmentHeadManager manager = new departmentHeadManager();
                    map = manager.createDepartmentHead(heads, split[3], nextHeadID, split[4]);
                    if(map.containsKey(0)){
                        System.out.println("there is already a department head for the department");
                    }else{
                        System.out.println("department head " + split[3] +" with " + nextHeadID + " and "
                                + split[4] + " is created");
                    }
                    return map;
                }else{// if none of these are true, then it is invalid input
                    System.out.println("invalid input");
                    map.put(0, heads);
                    return map;
                }
            case "change":
                if(split[1].equals("salary")){// if the user want to change salary, then call the change salary method and return the map signal nothing should be changed
                    workerManager manager = new workerManager();
                    System.out.println(manager.changeSalary(Integer.parseInt(split[2]), Integer.parseInt(split[3]), heads, Double.parseDouble(split[4])));
                    map.put(0, heads);
                    return map;
                }else if(split[1].equals("schedule")){//  if the user want to change schedule, then call the change schedule method and return the map signal nothing should be changed
                    workerManager manager = new workerManager();
                    System.out.println(manager.changeSchedule(Integer.parseInt(split[2]), Integer.parseInt(split[3]), heads, split[4], split[5], split[6]));
                    map.put(0, heads);
                    return map;
                }else{// if none of these are true, then it is invalid input
                    System.out.println("invalid input");
                    map.put(0, heads);
                    return map;
                }
            case "exit": // if the user enter exit, then return the map with a key value of -1 which signal exit
                map.put(-1, new ArrayList<>());
                return map;
            default: // for any other input, they are all just invalid
                System.out.println("invalid input");
                map.put(0, heads);
                return map;
        }
    }
}
