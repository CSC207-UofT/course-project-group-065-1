package DepartmentHeadOperations;


import java.io.IOException;
import java.util.ArrayList;

public class CreateHeadCommand implements HeadCommands {

    final private ArrayList<String> arguments;

    public CreateHeadCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute create department head command by calling create department head method in use case class
     * @param manager the use case class that contains the method to create department head
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) throws IOException {
        return manager.createDepartmentHead(this.arguments.get(0), this.arguments.get(1), Integer.parseInt(this.arguments.get(2)), false);
    }

    /**
     * undo create department head command by calling undo create department head method in use case class
     * @param manager the use case class that contains the method to undo create department head
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager) throws IOException{
        manager.undoCreateDepartmentHead(false);
        ArrayList<String> output = new ArrayList<>();
        output.add("U"); // indicates that the command can be undone and it is already undone
        return output;
    }
}
