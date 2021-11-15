package WorkerOperations;

import java.io.IOException;
import java.util.*;
public class CreateWorkerCommand implements WorkerCommands {

    /**
     * execute the create worker command
     * @param manager the use case class that contains method needed to execute the command
     * @param arguments arguments needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.createWorker(arguments.get(0), Integer.parseInt(arguments.get(1)), arguments.get(2), arguments.get(3), arguments.get(4), arguments.get(5));
    }
}
