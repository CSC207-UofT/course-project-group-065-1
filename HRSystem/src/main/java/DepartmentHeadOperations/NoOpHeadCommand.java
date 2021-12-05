package DepartmentHeadOperations;


import java.io.IOException;
import java.util.ArrayList;

public class NoOpHeadCommand implements HeadCommands{
    /**
     * execute the no operations command which is used when no previous command
     * @param manager the use case class that contains methods to execute the command
     * @return information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) throws IOException {
        ArrayList<String> output = new ArrayList<>();
        output.add("N P");// indicates no previous commands
        return output;
    }

    /**
     * undo the no operations command which is used when no previous command
     * @param manager the use case class that contains methods to undo the command
     * @return information needed to form output
     */
    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager) throws IOException{
        ArrayList<String> output = new ArrayList<>();
        output.add("N P");// indicates no previous commands
        return output;
    }
}
