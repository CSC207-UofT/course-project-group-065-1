package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public class AllHeadCommand implements HeadCommands {
    /**
     * execute the all head command by calling allHeads method from department head manager
     * @param manager the Department head manager use case class that contain allHeads method
     * @param arguments the arguments that the user pass in
     * @return list of all department heads
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException {
        return manager.allHeads();
    }
}
