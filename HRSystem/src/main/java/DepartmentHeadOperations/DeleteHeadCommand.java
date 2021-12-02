package DepartmentHeadOperations;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteHeadCommand implements HeadCommands {

    private final ArrayList<String> arguments;

    public DeleteHeadCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the delete department head command by calling the deleteHead method in use case class
     * @param manager the use case class that contains the deleteHead method
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) throws IOException {
        return manager.deleteHead(Integer.parseInt(this.arguments.get(0)), false);
    }
}
