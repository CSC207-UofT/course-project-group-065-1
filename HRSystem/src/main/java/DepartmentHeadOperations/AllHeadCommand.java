package DepartmentHeadOperations;

import java.io.IOException;
import java.util.ArrayList;

public class AllHeadCommand implements HeadCommands {
    /**
     * execute the all head command by calling allHeads method from department head manager
     * @param manager the Department head manager use case class that contain allHeads method
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) throws IOException {
        return manager.allHeads();
    }
}
