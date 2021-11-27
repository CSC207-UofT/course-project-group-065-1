package UI;

import DepartmentHeadOperations.*;
import Data.DepartmentHeadReadWriter;
import java.io.IOException;
import java.util.*;
import Helper.*;
public class DepartmentHeadController {


    HeadCommandExecutor headExecutor;


    /**
     * Constructor of the controller
     */
    public DepartmentHeadController() throws IOException, ClassNotFoundException {
        this.headExecutor = new HeadCommandExecutor(new DepartmentHeadReadWriter());
    }

    /**
     * take in the user input from presenter and call corresponding use case method and display the message
     * @param input the input typed by the user
     * @return the key information to form output.
     */
    public ArrayList<String> run(String input) throws IOException {
        Helper help = new Helper();
        String [] split = input.split(" ");// take in input and split them by space
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(split).subList(1, split.length));
        ArrayList<String> output = new ArrayList<>();
        switch(split[0]){// break into different cases based on the first number of the user's input
            case "2":
                if(help.checkInt(arguments.get(2))) {
                    CreateHeadCommand createHead = new CreateHeadCommand(arguments);
                    output.add("create head");
                    output.addAll(headExecutor.executeHeadCommand(createHead));
                }else{
                    output.add("invalid");
                }
                break;
            case "6":
                if(help.checkInt(arguments.get(0))) {
                    DeleteHeadCommand deleteHead = new DeleteHeadCommand(arguments);
                    output.add("delete head");
                    output.addAll(headExecutor.executeHeadCommand(deleteHead));
                }else{
                    output.add("invalid");
                }
                break;
            case "8":
                if(help.checkInt(arguments.get(1))) {
                    SearchByExperienceYearCommand searchByYear = new SearchByExperienceYearCommand(arguments);
                    output.add("list");
                    output.addAll(headExecutor.executeHeadCommand(searchByYear));
                }else{
                    output.add("invalid");
                }
                break;
            case "9":
                AllHeadCommand allHead = new AllHeadCommand();
                output.add("list");
                output.addAll(headExecutor.executeHeadCommand(allHead));
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
