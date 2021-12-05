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

    /**
     * undo the list all head commands which has no affect so no need to call any use case method
     * @param manager the Department head manager use case class that contain allHeads method
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager) throws IOException{
        ArrayList<String> output = new ArrayList<>();
        output.add("NU"); // indicates that this undo has no affect on program
        return output;
    }
}
