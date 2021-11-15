package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public interface WorkerCommands {
    /**
     * Interface that any commands about worker need to implement
     * @param manager use case class that needed to execute the command
     * @param arguments arguments that needed to execute the command
     * @return the information needed to form output
     */
    ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException;
}
