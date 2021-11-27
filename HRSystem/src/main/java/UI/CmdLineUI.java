package UI;


import java.io.IOException;
import java.util.*;
import Constants.*;
public class CmdLineUI {
    OptionMenuPresenter menu;
    WorkerPresenter worker;
    DepartmentHeadPresenter head;

    public CmdLineUI(OptionMenuPresenter menu, WorkerPresenter worker, DepartmentHeadPresenter head) {
        this.menu = menu;
        this.head = head;
        this.worker = worker;
    }
    /**
     * run the command line user interface
     */
    public void run() throws IOException, ClassNotFoundException {
        Message m = new Message();
        System.out.println(m.getWelcomeMessage());
        DepartmentHeadController headController = new DepartmentHeadController();// define a web.SystemController which takes call method and return message based on user input
        WorkerController workerController = new WorkerController();
        String input;
        do{// repeated running the InOutHandler while the input is not exit
            // display the menu option for user
            this.menu.display();
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            String op = input.split(" ")[0];
            ArrayList<String> output;
            if (op.equals("2") || op.equals("6") || op.equals("8")){
                output = headController.run(input);
                head.display(output.remove(0), output);
            } else if (op.equals("9")) {
                ArrayList<String> workerOutput = workerController.run(input);
                ArrayList<String> headOutput = headController.run(input);
                worker.display(workerOutput.remove(0), workerOutput);
                head.display(headOutput.remove(0), headOutput);
            } else {
                output = workerController.run(input);
                worker.display(output.remove(0), output);
            }

            // produce the message that the user should see

            // display the output
        }while(!input.equals("exit"));
        System.out.println(m.getThanksMessage());
    }

}

