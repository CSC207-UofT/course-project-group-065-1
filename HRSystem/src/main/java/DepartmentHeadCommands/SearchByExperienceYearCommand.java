package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public class SearchByExperienceYearCommand implements HeadCommands {
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException {
        return manager.searchByExperienceYear(arguments.get(0), Integer.parseInt(arguments.get(1)));
    }
}
