package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public class SearchByExperienceYearCommand implements HeadCommands {
    /**
     * execute the search by experience year command by calling method from the given use case class
     * @param manager the use case class that contains methods to execute the command
     * @param arguments arguments needed to execute the given command
     * @return message that the user should see
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException {
        return manager.searchByExperienceYear(arguments.get(0), Integer.parseInt(arguments.get(1)));
    }
}
