package WorkerCommands;

import java.io.IOException;
import java.util.*;
public class WorkerCommandExecutor {
    private final WorkerManager workerManager;

    public WorkerCommandExecutor(){
        this.workerManager = new WorkerManager();
    }

    public ArrayList<String> executeWorkerCommand(WorkerCommands operation, ArrayList<String> arguments) throws IOException {
        return operation.execute(this.workerManager, arguments);
    }
}
