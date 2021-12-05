package DepartmentHeadOperations;

import java.io.IOException;
import java.util.ArrayList;

public class SearchByExperienceYearCommand implements HeadCommands {

    final private ArrayList<String> arguments;

    public SearchByExperienceYearCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the search by experience year command by calling method from the given use case class
     * @param manager the use case class that contains methods to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) throws IOException {
        return manager.searchByExperienceYear(Integer.parseInt(this.arguments.get(0)));
    }

    /**
     * undo the search by experience year command which doesn't need to change anything
     * @param manager the use case class that contains methods to undo the command
     * @return information needed to form output
     */
    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager) throws IOException{
        ArrayList<String> output = new ArrayList<>();
        output.add("NU");// undo have no affect on program
        return output;
    }
}
