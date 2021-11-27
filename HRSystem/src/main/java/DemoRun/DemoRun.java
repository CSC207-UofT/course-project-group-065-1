package DemoRun;

/*
 These imports are used to initialize 2 new ser files so uncomment them only when creating the 2 new ser files
 import Data.DepartmentHeadReadWriter;
 import java.util.*;
 import Data.WorkerReadWriter;
*/

import UI.CmdLineUI;
import UI.DepartmentHeadPresenter;
import UI.OptionMenuPresenter;
import UI.WorkerPresenter;

import java.io.IOException;

public class DemoRun {
    public static void main(String [] args) throws IOException, ClassNotFoundException {
        /*
        When start running to code for the first time or want to reset the system,
        Please delete the existing ser files comment out the command line interface code
        and uncomment the following code and run it for once
        This will create an empty new ser files and then comment the following code and run the
        command line interface.
        */

        /*
        DepartmentHeadReadWriter headReadWriter = new DepartmentHeadReadWriter();
        WorkerReadWriter workerReadWriter = new WorkerReadWriter();
        headReadWriter.saveToFile("heads.ser", new ArrayList<>());
        workerReadWriter.saveToFile("workers.ser", new ArrayList<>());
        System.out.println(headReadWriter.readFromFile("heads.ser"));
        System.out.println(workerReadWriter.readFromFile("workers.ser"));
        */

        // demo run of the HR System by define a new web.CmdLineUI instance and run the user interface
        WorkerPresenter worker = new WorkerPresenter();
        DepartmentHeadPresenter head = new DepartmentHeadPresenter();
        OptionMenuPresenter menu = new OptionMenuPresenter();
        CmdLineUI ui = new CmdLineUI(menu, worker, head);
        ui.run();
    }
}
