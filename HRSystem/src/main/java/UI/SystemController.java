package UI;

import DepartmentHeadOperations.*;
import WorkerOperations.*;
import Data.DepartmentHeadReadWriter;
import Data.WorkerReadWriter;
import java.io.IOException;
import java.util.*;
public class SystemController {

    WorkerCommandExecutor workerExecutor;
    HeadCommandExecutor headExecutor;


    /**
     * Constructor of the controller
     */
    public SystemController() throws IOException, ClassNotFoundException {
        this.workerExecutor = new WorkerCommandExecutor(new WorkerReadWriter());
        this.headExecutor = new HeadCommandExecutor(new DepartmentHeadReadWriter());
    }

    /**
     * take in the user input from presenter and call corresponding use case method and display the message
     * @param input the input typed by the user
     * @return the key information to form output.
     */
    public ArrayList<String> run(String input) throws IOException {
        String [] split = input.split(" ");// take in input and split them by space
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(split).subList(1, split.length));
        ArrayList<String> output = new ArrayList<>();
        switch(split[0]){// break into different cases based on the first number of the user's input
            case "1":
                CreateWorkerCommand createWorker = new CreateWorkerCommand(arguments);
                output.add("create worker");
                output.addAll(workerExecutor.executeWorkerCommand(createWorker));
                break;
            case "2":
                CreateHeadCommand createHead = new CreateHeadCommand(arguments);
                output.add("create head");
                output.addAll(headExecutor.executeHeadCommand(createHead));
                break;
            case "3":
                ChangeSalaryCommand changeSalary = new ChangeSalaryCommand(arguments);
                output.add("change salary");
                output.addAll(workerExecutor.executeWorkerCommand(changeSalary));
                break;
            case "4":
                ChangeScheduleCommand changeSchedule = new ChangeScheduleCommand(arguments);
                output.add("change schedule");
                output.addAll(workerExecutor.executeWorkerCommand(changeSchedule));
                break;
            case "5":
                DeleteWorkerCommand deleteWorker = new DeleteWorkerCommand(arguments);
                output.add("delete worker");
                output.addAll(workerExecutor.executeWorkerCommand(deleteWorker));
                break;
            case "6":
                DeleteHeadCommand deleteHead = new DeleteHeadCommand(arguments);
                output.add("delete head");
                output.addAll(headExecutor.executeHeadCommand(deleteHead));
                break;
            case "7":
                SearchByNameCommand searchByName = new SearchByNameCommand(arguments);
                output.add("list");
                output.addAll(workerExecutor.executeWorkerCommand(searchByName));
                break;
            case "8":
                SearchByExperienceYearCommand searchByYear = new SearchByExperienceYearCommand(arguments);
                output.add("list");
                output.addAll(headExecutor.executeHeadCommand(searchByYear));
                break;
            case "9":
                AllWorkerCommand allWorker = new AllWorkerCommand();
                AllHeadCommand allHead = new AllHeadCommand();
                output.add("list");
                output.addAll(headExecutor.executeHeadCommand(allHead));
                output.addAll(workerExecutor.executeWorkerCommand(allWorker));
                break;
            case "exit":
                output.add("exit");
                break;
            default:
                output.add("not valid");
                break;
        }
        return output;
    }
}
