package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeSalaryCommand implements WorkerCommands {
    final private ArrayList<String> arguments;

    public ChangeSalaryCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the change salary command
     * @param manager the user class that contains methods to execute the change salary command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        return manager.changeSalary(Integer.parseInt(this.arguments.get(0)), Double.parseDouble(this.arguments.get(1)));
    }
}
