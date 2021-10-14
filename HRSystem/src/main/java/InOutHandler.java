import java.util.*;
public class InOutHandler {
    /*
    handles input

    only focuses on relevant input, extra content at end will be ignored
     */
    Scanner in;

    public InOutHandler(){
        in = new Scanner(System.in);
    }

    public HashMap<Integer, ArrayList<departmentHead>> run(ArrayList<departmentHead> heads, int nextWorkerID, int nextHeadID) {
        String input = in.nextLine();
        String [] split = input.split(" ");
        HashMap<Integer, ArrayList<departmentHead>> map = new HashMap<>();
        switch(split[0]){
            case "create":
                if(split[1].equals("worker")){
                    workerManager manager = new workerManager();
                    map = manager.createWorker(heads, split[2], Integer.parseInt(split[3]), nextWorkerID, split[4], split[5], split[6], split[7]);
                    if(map.containsKey(0)){
                        System.out.println("no department head for the department");
                    }else{
                        System.out.println("worker " + split[2] + " Bob with id " + nextWorkerID + ", salary " + split[3] + " and department " + split[4] + " is created");
                    }
                    return map;
                }else if(split[1].equals("department")){
                    departmentHeadManager manager = new departmentHeadManager();
                    map = manager.createDepartmentHead(heads, split[3], nextHeadID, split[4]);
                    if(map.containsKey(0)){
                        System.out.println("there is already a department head for the department");
                    }else{
                        System.out.println("department head " + split[3] +" with " + nextHeadID + " and "
                                + split[4] + " is created");
                    }
                    return map;
                }else{
                    System.out.println("invalid input");
                    map.put(0, heads);
                    return map;
                }
            case "change":
                if(split[1].equals("salary")){
                    workerManager manager = new workerManager();
                    System.out.println(manager.changeSalary(Integer.parseInt(split[2]), Integer.parseInt(split[3]), heads, Double.parseDouble(split[4])));
                    map.put(0, heads);
                    return map;
                }else if(split[1].equals("schedule")){
                    workerManager manager = new workerManager();
                    System.out.println(manager.changeSchedule(Integer.parseInt(split[2]), Integer.parseInt(split[3]), heads, split[4], split[5], split[6]));
                    map.put(0, heads);
                    return map;
                }else{
                    System.out.println("invalid input");
                    map.put(0, heads);
                    return map;
                }
            case "exit":
                map.put(-1, new ArrayList<>());
                return map;
            default:
                System.out.println("invalid input");
                map.put(0, heads);
                return map;
        }
    }
}
