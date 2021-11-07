import java.util.*;
public class SystemController {

    final private WorkerManager workerManager;
    final private DepartmentHeadManager headManager;

    public SystemController(){
        this.workerManager = new WorkerManager();
        this.headManager = new DepartmentHeadManager();
    }

    /**
     * take in the user input from presenter and call corresponding use case method and display the message
     * @param input the input typed by the user
     * @return the output that the user should see.
     */
    public ArrayList<String> run(String input) {
        String [] split = input.split(" ");// take in input and split them by space
        ArrayList<String> output = new ArrayList<>();
        switch(split[0]){// break into different cases based on the first words of the user's input
            case "1":
                output.add(this.workerManager.CreateWorker(split[1], Integer.parseInt(split[2]), split[3], split[4], split[5], split[6]));
                return output;
            case "2":
                output.add(this.headManager.createDepartmentHead(split[1], split[2],Integer.parseInt(split[3])));
                return output;
            case "3":
                output.add(this.workerManager.changeSalary(Integer.parseInt(split[1]), Double.parseDouble(split[2])));
                return output;
            case "4":
                output.add(this.workerManager.changeSchedule(Integer.parseInt(split[1]), split[2], split[3], split[4]));
                return output;
            case "5":
                output.add(this.workerManager.deleteWorker(Integer.parseInt(split[1])));
                return output;
            case "6":
                output.add(this.headManager.deleteHead(Integer.parseInt(split[1])));
                return output;
            case "7":
                output = this.workerManager.searchByName(split[1]);
                return output;
            case "8":
                output = this.headManager.searchByExperienceYear(split[1], Integer.parseInt(split[2]));
                return output;
            case "exit":
                output.add("System exited");
                return output;
            default:
                output.add("Incorrect command entered, please try again");
                return output;
        }
    }
}
