package DepartmentHeadOperations;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteHeadCommand implements HeadCommands {
    /**
     * execute the delete department head command by calling the deleteHead method in use case class
     * @param manager the use case class that contains the deleteHead method
     * @param arguments arguments that the user pass in
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException {
        return manager.deleteHead(Integer.parseInt(arguments.get(0)));
    }
}
