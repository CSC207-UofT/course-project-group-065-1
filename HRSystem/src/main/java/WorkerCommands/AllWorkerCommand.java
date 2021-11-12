package WorkerCommands;

import java.io.IOException;
import java.util.ArrayList;

public class AllWorkerCommand implements WorkerCommands {
    /**
     * execute the all worker command
     * @param manager the use case class that contains method to execute the given command
     * @param arguments argument needed to execute the given command
     * @return message that the user should see
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.allWorker();
    }
}
