package WorkerOperations;

import Data.WorkerReadWriter;

import java.io.IOException;
import java.util.*;
public class WorkerCommandExecutor {
    private final WorkerManager workerManager;

    /**
     * constructor of the WorkerCommandExecutor which is the invoker
     * @param readWriter the readWrite that is used to read and write to ser file
     */
    public WorkerCommandExecutor(WorkerReadWriter readWriter) throws IOException, ClassNotFoundException {
        this.workerManager = new WorkerManager(readWriter);
    }

    /**
     * execute the given command
     * @param operation the command object that needs to be executed
     * @param arguments the arguments needed to execute the given command
     * @return the information needed to form output
     */
    public ArrayList<String> executeWorkerCommand(WorkerCommands operation, ArrayList<String> arguments) throws IOException {
        return operation.execute(this.workerManager, arguments);
    }
}
