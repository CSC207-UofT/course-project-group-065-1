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
        return manager.searchByExperienceYear(this.arguments.get(0), Integer.parseInt(this.arguments.get(1)));
    }

    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager) throws IOException{
        ArrayList<String> output = new ArrayList<>();
        output.add("NU");
        return output;
    }
}
