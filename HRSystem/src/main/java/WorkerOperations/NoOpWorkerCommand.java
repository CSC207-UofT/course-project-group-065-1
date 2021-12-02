package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class NoOpWorkerCommand implements WorkerCommands{

    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        ArrayList<String> output = new ArrayList<>();
        output.add("N P");
        return output;
    }

    @Override
    public ArrayList<String> undo(WorkerManager manager) throws IOException{
        ArrayList<String> output = new ArrayList<>();
        output.add("N P");
        return output;
    }
}
