package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public interface WorkerCommands {
    /**
     * Interface that any commands about worker need to implement
     * @param manager use case class that needed to execute the command
     * @return the information needed to form output
     */
    ArrayList<String> execute(WorkerManager manager) throws IOException;
}
