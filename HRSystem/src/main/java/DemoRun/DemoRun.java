package DemoRun;

import web.CmdLineUI;

import java.io.IOException;

public class DemoRun {
    public static void main(String [] args) throws IOException{
        // demo run of the HR System by define a new web.CmdLineUI instance and run the user interface
        CmdLineUI ui = new CmdLineUI();
        ui.run();
    }
}
