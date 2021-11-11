package WorkerCommands;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeScheduleCommand implements WorkerCommands {

    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.changeSchedule(Integer.parseInt(arguments.get(0)), arguments.get(1), arguments.get(2), arguments.get(3));
    }
}
