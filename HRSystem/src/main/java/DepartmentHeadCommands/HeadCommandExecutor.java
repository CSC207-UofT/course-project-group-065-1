package DepartmentHeadCommands;

import java.io.IOException;
import java.util.*;
public class HeadCommandExecutor {
    private final DepartmentHeadManager headManager;

    public HeadCommandExecutor(){
        this.headManager = new DepartmentHeadManager();
    }

    public ArrayList<String> executeHeadCommand(HeadCommands operation, ArrayList<String> arguments) throws IOException {
        return operation.execute(this.headManager, arguments);
    }
}
