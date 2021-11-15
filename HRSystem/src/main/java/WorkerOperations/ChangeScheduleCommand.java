package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeScheduleCommand implements WorkerCommands {

    /**
     * execute the change schedule commands
     * @param manager the use case class that contains methods that is needed to execute the command
     * @param arguments arguments needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.changeSchedule(Integer.parseInt(arguments.get(0)), arguments.get(1), arguments.get(2), arguments.get(3));
    }
}
