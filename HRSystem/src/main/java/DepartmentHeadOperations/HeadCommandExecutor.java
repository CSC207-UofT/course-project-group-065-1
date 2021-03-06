package DepartmentHeadOperations;

import Data.DepartmentHeadReadWriter;

import java.io.IOException;
import java.util.*;
public class HeadCommandExecutor {
    private final DepartmentHeadManager headManager;
    private final ArrayList<HeadCommands> history;
    /**
     * Constructor of the invoker of commands to department head
     * @param readWriter the readWriter used to read and write to ser file
     */
    public HeadCommandExecutor(DepartmentHeadReadWriter readWriter) throws IOException, ClassNotFoundException {
        this.headManager = new DepartmentHeadManager(readWriter, false);
        this.history = new ArrayList<>();
    }

    /**
     * Execute the execute method with the given command object
     * @param operation the command object want to be executed
     * @return the information needed to form output
     */
    public ArrayList<String> executeHeadCommand(HeadCommands operation) throws IOException {
        this.history.add(operation);
        return operation.execute(this.headManager);
    }

    /**
     * execute the undo method with the given command object
     * @param operation the command object want to be undone
     * @return the information needed to form output
     */
    public ArrayList<String> undoHeadCommand(HeadCommands operation) throws IOException {
        return operation.undo(this.headManager);
    }

    /**
     * get the previous command of department head
     * @return the previous command of deparatment head
     */
    public HeadCommands previousCommand(){
        if(this.history.isEmpty()){
            return new NoOpHeadCommand();// no operation command which doesn't do anything
        }
        return this.history.remove(this.history.size() - 1);
    }
}
