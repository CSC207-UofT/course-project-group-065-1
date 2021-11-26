package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeScheduleCommand implements WorkerCommands {
    final private ArrayList<String> arguments;

    public ChangeScheduleCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the change schedule commands
     * @param manager the use case class that contains methods that is needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        return manager.changeSchedule(this.arguments);
    }
}
