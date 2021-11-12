package WorkerCommands;

import java.util.ArrayList;

public class SearchByNameCommand implements WorkerCommands {
    /**
     * execute the search by name command
     * @param manager the use case class that contains methods that is needed to execute the command
     * @param arguments arguments needed to execute the command
     * @return message that the user should see
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments){
        return manager.searchByName(arguments.get(0));
    }
}
