package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public interface HeadCommands {
    ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException;
}
