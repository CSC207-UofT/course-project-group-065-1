package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public class CreateHeadCommand implements HeadCommands {

    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException {
        return manager.createDepartmentHead(arguments.get(0), arguments.get(1), Integer.parseInt(arguments.get(2)));
    }
}
