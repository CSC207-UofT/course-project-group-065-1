package DepartmentHeadCommands;

import java.io.IOException;
import java.util.ArrayList;

public interface HeadCommands {
    /**
     * The interface that all department heads commands must implement
     * @param manager the use case class that contains methods to execute the command
     * @param arguments arguments needed to execute the given command
     * @return message that the user should see
     */
    ArrayList<String> execute(DepartmentHeadManager manager, ArrayList<String> arguments) throws IOException;
}
