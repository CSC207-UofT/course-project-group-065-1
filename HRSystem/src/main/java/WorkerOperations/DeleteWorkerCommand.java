package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteWorkerCommand implements WorkerCommands {
    final private ArrayList<String> arguments;

    public DeleteWorkerCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the delete worker command
     * @param manager the use case class that contains methods that is needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        return manager.deleteWorker(Integer.parseInt(this.arguments.get(0)));
    }
}
