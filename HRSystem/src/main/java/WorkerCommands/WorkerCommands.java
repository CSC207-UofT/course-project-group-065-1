package WorkerCommands;

import java.io.IOException;
import java.util.ArrayList;

public interface WorkerCommands {
    ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException;
}
