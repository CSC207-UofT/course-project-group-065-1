package UI;

import DepartmentHeadOperations.*;
import Data.DepartmentHeadReadWriter;
import java.io.IOException;
import java.util.*;
public class DepartmentHeadInputHandler {


    HeadCommandExecutor headExecutor;


    /**
     * Constructor of the controller
     */
    public DepartmentHeadInputHandler() throws IOException, ClassNotFoundException {
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
            case "2":
                if(checkInt(arguments.get(2))) {
                    CreateHeadCommand createHead = new CreateHeadCommand(arguments);
                    output.add("create head");
                    output.addAll(headExecutor.executeHeadCommand(createHead));
                }else{
                    output.add("invalid");
                }
                break;
            case "6":
                if(checkInt(arguments.get(0))) {
                    DeleteHeadCommand deleteHead = new DeleteHeadCommand(arguments);
                    output.add("delete head");
                    output.addAll(headExecutor.executeHeadCommand(deleteHead));
                }else{
                    output.add("invalid");
                }
                break;
            case "8":
                if(arguments.get(0).equals("year")) {
                    if(checkInt(arguments.get(1))) {
                        arguments.remove(0);
                        SearchByExperienceYearCommand searchByYear = new SearchByExperienceYearCommand(arguments);
                        output.add("list");
                        output.addAll(headExecutor.executeHeadCommand(searchByYear));
                    }
                    else {output.add("invalid");
                    }
                }
                else if (arguments.get(0).equals("id")){
                    if(checkInt(arguments.get(1))) {
                        arguments.remove(0);
                        SearchByIDCommand searchByID = new SearchByIDCommand(arguments);
                        output.add("list");
                        output.addAll(headExecutor.executeHeadCommand(searchByID));
                    }
                    else {output.add("invalid");
                    }
                }
                else {output.add("invalid");
                }
                break;
            case "9":
                AllHeadCommand allHead = new AllHeadCommand();
                output.add("list");
                output.addAll(headExecutor.executeHeadCommand(allHead));
                break;
            case "11":
                HeadCommands command = headExecutor.previousCommand();
                output.add("undo");
                output.addAll(headExecutor.undoHeadCommand(command));
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

    private boolean checkInt(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
