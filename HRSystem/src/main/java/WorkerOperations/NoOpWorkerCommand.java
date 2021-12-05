package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class NoOpWorkerCommand implements WorkerCommands{

    /**
     * execute the no operations command for worker which is used when no previous command
     * @param manager the use case class that contains methods to execute the command
     * @return information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        ArrayList<String> output = new ArrayList<>();
        output.add("N P");// no previous command
        return output;
    }

    /**
     * undo the no operations command which is used when no previous command
     * @param manager the use case class that contains methods to undo the command
     * @return information needed to form output
     */
    @Override
    public ArrayList<String> undo(WorkerManager manager) throws IOException{
        ArrayList<String> output = new ArrayList<>();
        output.add("N P");// no previous command
        return output;
    }
}
