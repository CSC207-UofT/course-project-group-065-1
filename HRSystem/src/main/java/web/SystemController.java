package web;

import DepartmentHeadCommands.*;
import WorkerCommands.*;
import java.io.IOException;
import java.util.*;
public class SystemController {

    WorkerCommandExecutor workerExecutor;
    HeadCommandExecutor headExecutor;


    public SystemController() throws IOException, ClassNotFoundException {
        this.workerExecutor = new WorkerCommandExecutor();
        this.headExecutor = new HeadCommandExecutor();
    }

    /**
     * take in the user input from presenter and call corresponding use case method and display the message
     * @param input the input typed by the user
     * @return the output that the user should see.
     */
    public ArrayList<String> run(String input) throws IOException {
        String [] split = input.split(" ");// take in input and split them by space
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(split).subList(1, split.length));
        ArrayList<String> output = new ArrayList<>();
        switch(split[0]){// break into different cases based on the first number of the user's input
            case "1":
                CreateWorkerCommand createWorker = new CreateWorkerCommand();
                output = workerExecutor.executeWorkerCommand(createWorker, arguments);
                break;
            case "2":
                CreateHeadCommand createHead = new CreateHeadCommand();
                output = headExecutor.executeHeadCommand(createHead, arguments);
                break;
            case "3":
                ChangeSalaryCommand changeSalary = new ChangeSalaryCommand();
                output = workerExecutor.executeWorkerCommand(changeSalary, arguments);
                break;
            case "4":
                ChangeScheduleCommand changeSchedule = new ChangeScheduleCommand();
                output = workerExecutor.executeWorkerCommand(changeSchedule, arguments);
                break;
            case "5":
                DeleteWorkerCommand deleteWorker = new DeleteWorkerCommand();
                output = workerExecutor.executeWorkerCommand(deleteWorker, arguments);
                break;
            case "6":
                DeleteHeadCommand deleteHead = new DeleteHeadCommand();
                output = headExecutor.executeHeadCommand(deleteHead, arguments);
                break;
            case "7":
                SearchByNameCommand searchByName = new SearchByNameCommand();
                output = workerExecutor.executeWorkerCommand(searchByName, arguments);
                break;
            case "8":
                SearchByExperienceYearCommand searchByYear = new SearchByExperienceYearCommand();
                output = headExecutor.executeHeadCommand(searchByYear, arguments);
                break;
            case "9":
                AllWorkerCommand allWorker = new AllWorkerCommand();
                AllHeadCommand allHead = new AllHeadCommand();
                output = headExecutor.executeHeadCommand(allHead, arguments);
                output.addAll(workerExecutor.executeWorkerCommand(allWorker, arguments));
                break;
            case "exit":
                output.add("System exited");
                break;
            default:
                output.add("Incorrect command entered, please try again");
                break;
        }
        return output;
    }
}
