package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public class AllHeadCommand implements HeadCommands {
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException {
        return manager.allHeads();
    }
}
