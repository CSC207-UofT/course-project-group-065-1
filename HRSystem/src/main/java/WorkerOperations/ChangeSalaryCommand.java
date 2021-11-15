package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeSalaryCommand implements WorkerCommands {

    /**
     * execute the change salary command
     * @param manager the user class that contains methods to execute the change salary command
     * @param arguments arguments needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.changeSalary(Integer.parseInt(arguments.get(0)), Double.parseDouble(arguments.get(1)));
    }
}
