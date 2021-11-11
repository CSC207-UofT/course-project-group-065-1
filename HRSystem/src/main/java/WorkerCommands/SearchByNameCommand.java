package WorkerCommands;

import java.util.ArrayList;

public class SearchByNameCommand implements WorkerCommands {
    @Override
    public ArrayList<String> execute(WorkerManager manager, ArrayList<String> arguments){
        return manager.searchByName(arguments.get(0));
    }
}
