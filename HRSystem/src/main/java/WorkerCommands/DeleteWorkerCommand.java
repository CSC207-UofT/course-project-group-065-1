package WorkerCommands;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteWorkerCommand implements WorkerCommands {
    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.deleteWorker(Integer.parseInt(arguments.get(0)));
    }
}
