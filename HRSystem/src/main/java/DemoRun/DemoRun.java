package DemoRun;


import UI.*;

import java.io.IOException;

public class DemoRun {
    public static void main(String [] args) throws IOException, ClassNotFoundException {
        // demo run of the HR System by define a new web.CmdLineUI instance and run the user interface
        WorkerOutputHandler worker = new WorkerOutputHandler();
        DepartmentHeadOutputHandler head = new DepartmentHeadOutputHandler();
        OptionMenuPresenter menu = new OptionMenuPresenter();
        DepartmentHeadInputHandler headInputHandler = new DepartmentHeadInputHandler();
        WorkerInputHandler workerInputHandler = new WorkerInputHandler();
        CmdLineUI ui = new CmdLineUI(menu, worker, head, headInputHandler, workerInputHandler);
        ui.run();

    }
}
