package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteHeadCommand implements HeadCommands {
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException {
        return manager.deleteHead(Integer.parseInt(arguments.get(0)));
    }
}
