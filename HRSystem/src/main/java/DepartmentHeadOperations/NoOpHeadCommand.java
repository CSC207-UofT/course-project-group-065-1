package DepartmentHeadOperations;


import java.io.IOException;
import java.util.ArrayList;

public class NoOpHeadCommand implements HeadCommands{
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) throws IOException {
        ArrayList<String> output = new ArrayList<>();
        output.add("N P");
        return output;
    }

    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager) throws IOException{
        ArrayList<String> output = new ArrayList<>();
        output.add("N P");
        return output;
    }
}
