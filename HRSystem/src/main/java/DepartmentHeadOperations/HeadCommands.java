package DepartmentHeadOperations;


import java.io.IOException;
import java.util.ArrayList;

public interface HeadCommands {
    /**
     * The execute methods that all department heads commands must implement
     * @param manager the use case class that contains methods to execute the command
     * @return the information needed to form output
     */
    ArrayList<String> execute(DepartmentHeadManager manager) throws IOException;

    /**
     * The undo methods that all department heads commands must implement
     * @param manager the use case class that contains methods to undo the command
     * @return the information needed to form output
     */
    ArrayList<String> undo(DepartmentHeadManager manager) throws IOException;
}
