package WorkerOperations;

import java.util.ArrayList;

public class SearchByIDCommand implements WorkerCommands {
    final private ArrayList<String> arguments;

    public SearchByIDCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the search by name command
     * @param manager the use case class that contains methods that is needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager){
        return manager.searchByID(Integer.parseInt(this.arguments.get(0)));
    }

    /**
     * undo the search by name command
     * @param manager the use case class that contains methods that is needed to undo the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> undo(WorkerManager manager){
        ArrayList<String> output = new ArrayList<>();
        output.add("NU");// undo has no affect
        return output;
    }
}