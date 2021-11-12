package WorkerCommands;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteWorkerCommand implements WorkerCommands {
    /**
     * execute the delete worker command
     * @param manager the use case class that contains methods that is needed to execute the command
     * @param arguments arguments needed to execute the command
     * @return message that the user should see
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.deleteWorker(Integer.parseInt(arguments.get(0)));
    }
}
