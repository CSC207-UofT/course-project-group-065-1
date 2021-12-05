package DepartmentHeadOperations;

import java.util.ArrayList;

public class SearchByIDCommand implements HeadCommands {

    final private ArrayList<String> arguments;

    public SearchByIDCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the search by ID command by calling method from the given use case class
     * @param manager the use case class that contains methods to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) {
        return manager.searchByID(Integer.parseInt(this.arguments.get(0)));
    }

    /**
     * undo the search by ID command which doesn't change anything
     * @param manager the use case class that contains methods to undo the command
     * @return information needed to form output
     */
    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager){
        ArrayList<String> output = new ArrayList<>();
        output.add("NU");// undo has no affect on program
        return output;
    }
}
