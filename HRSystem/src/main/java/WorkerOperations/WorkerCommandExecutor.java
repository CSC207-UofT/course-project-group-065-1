package WorkerOperations;

import Data.WorkerReadWriter;

import java.io.IOException;
import java.util.*;
public class WorkerCommandExecutor {
    private final WorkerManager workerManager;
    private final ArrayList<WorkerCommands> history;

    /**
     * constructor of the WorkerCommandExecutor which is the invoker
     * @param readWriter the readWrite that is used to read and write to ser file
     */
    public WorkerCommandExecutor(WorkerReadWriter readWriter) throws IOException, ClassNotFoundException {
        this.workerManager = new WorkerManager(readWriter, false);
        this.history = new ArrayList<>();
    }

    /**
     * execute the given command
     * @param operation the command object that needs to be executed
     * @return the information needed to form output
     */
    public ArrayList<String> executeWorkerCommand(WorkerCommands operation) throws IOException {
        this.history.add(operation);
        return operation.execute(this.workerManager);
    }

    /**
     * undo the given command
     * @param operation the command object that needs to be undone
     * @return the information needed to form output
     */
    public ArrayList<String> undoWorkerCommand(WorkerCommands operation) throws IOException {
        return operation.undo(this.workerManager);
    }

    /**
     * return the previous worker command
     * @return the previous worker command
     */
    public WorkerCommands previousCommand(){
        if(this.history.isEmpty()){
            return new NoOpWorkerCommand();
        }
        return this.history.remove(this.history.size() - 1);
    }
}
