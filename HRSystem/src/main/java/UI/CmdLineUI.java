package UI;


import java.io.IOException;
import java.util.*;
import Constants.*;
public class CmdLineUI {
    OptionMenuPresenter menu;
    WorkerOutputHandler workerOutputHandler;
    DepartmentHeadOutputHandler headOutputHandler;
    DepartmentHeadInputHandler headInputHandler;
    WorkerInputHandler workerInputHandler;

    /**
     * initialize a command line user interface object
     * @param menu the option menu presenter used
     * @param worker the worker presenter used
     * @param head the department head presenter used
     * @param headController the department head controller used
     * @param workerController the worker controller used
     */
    public CmdLineUI(OptionMenuPresenter menu, WorkerOutputHandler worker, DepartmentHeadOutputHandler head, DepartmentHeadInputHandler headController, WorkerInputHandler workerController) {
        this.menu = menu;
        this.headOutputHandler = head;
        this.workerOutputHandler = worker;
        this.headInputHandler = headController;
        this.workerInputHandler = workerController;
    }
    /**
     * run the command line user interface
     */
    public void run() throws IOException {
        Message m = new Message();
        System.out.println(m.getWelcomeMessage());
        String input;
        do{// repeated running the InOutHandler while the input is not exit
            // display the menu option for user
            this.menu.display();
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            String op = input.split(" ")[0];
            ArrayList<String> output;
            if (op.equals("2") || op.equals("6") || op.equals("8") || op.equals("11")){ // if it is an operation on department head, then use department head controller and presenter
                output = headInputHandler.run(input);
                headOutputHandler.display(output.remove(0), output);
            } else if (op.equals("9")) {// if it is list all employees, then use controller and presenter of both department head and worker
                ArrayList<String> workerOutput = workerInputHandler.run(input);
                ArrayList<String> headOutput = headInputHandler.run(input);
                workerOutputHandler.display(workerOutput.remove(0), workerOutput);
                headOutputHandler.display(headOutput.remove(0), headOutput);
            } else {// if it is an operation on worker, then use worker controller and presenter
                output = workerInputHandler.run(input);
                workerOutputHandler.display(output.remove(0), output);
            }
        }while(!input.equals("exit"));
        System.out.println(m.getThanksMessage());
    }

}

