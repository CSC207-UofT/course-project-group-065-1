package WorkerCommands;

import java.io.IOException;
import java.util.*;
public class CreateWorkerCommand implements WorkerCommands {

    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.createWorker(arguments.get(0), Integer.parseInt(arguments.get(1)), arguments.get(2), arguments.get(3), arguments.get(4), arguments.get(5));
    }
}
