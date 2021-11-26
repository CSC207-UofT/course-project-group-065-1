package DepartmentHeadOperations;

import Data.DepartmentHeadReadWriter;

import java.io.IOException;
import java.util.*;
public class HeadCommandExecutor {
    private final DepartmentHeadManager headManager;

    /**
     * Constructor of the invoker of commands to department head
     * @param readWriter the readWriter used to read and write to ser file
     */
    public HeadCommandExecutor(DepartmentHeadReadWriter readWriter) throws IOException, ClassNotFoundException {
        this.headManager = new DepartmentHeadManager(readWriter);
    }

    /**
     * Execute the execute method with the given command object
     * @param operation the command object want to be executed
     * @return the information needed to form output
     */
    public ArrayList<String> executeHeadCommand(HeadCommands operation) throws IOException {
        return operation.execute(this.headManager);
    }
}
