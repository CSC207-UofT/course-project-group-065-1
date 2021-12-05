package WorkerOperations;

import java.io.IOException;
import java.util.*;
public class CreateWorkerCommand implements WorkerCommands {
    final private ArrayList<String> arguments;

    public CreateWorkerCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the create worker command
     * @param manager the use case class that contains method needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        return manager.createWorker(this.arguments,false);
    }

    /**
     * undo the create worker command
     * @param manager the use case class that contains method needed to undo the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> undo(WorkerManager manager) throws IOException{
        manager.undoCreateWorker(false);
        ArrayList<String> output = new ArrayList<>();
        output.add("U");// undo is successful
        return output;
    }
}
