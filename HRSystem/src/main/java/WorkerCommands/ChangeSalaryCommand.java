package WorkerCommands;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeSalaryCommand implements WorkerCommands {

    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments) throws IOException {
        return manager.changeSalary(Integer.parseInt(arguments.get(0)), Double.parseDouble(arguments.get(1)));
    }
}
