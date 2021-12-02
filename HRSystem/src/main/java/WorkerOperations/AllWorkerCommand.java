package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class AllWorkerCommand implements WorkerCommands {
    /**
     * execute the all worker command
     * @param manager the use case class that contains method to execute the given command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        return manager.allWorker();
    }

    @Override
    public ArrayList<String> undo(WorkerManager manager){
        ArrayList<String> output = new ArrayList<>();
        output.add("NU");
        return output;
    }
}
