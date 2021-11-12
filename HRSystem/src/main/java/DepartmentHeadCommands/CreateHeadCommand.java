package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public class CreateHeadCommand implements HeadCommands {

    /**
     * execute create department head command by calling create department head method in use case class
     * @param manager the use case class that contains the method to create department head
     * @param arguments arguments that the user pass in
     * @return message that the user will see
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException {
        return manager.createDepartmentHead(arguments.get(0), arguments.get(1), Integer.parseInt(arguments.get(2)));
    }
}
