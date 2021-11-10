import java.util.*;
public class CmdLineUI {
    /**
     * run the command line user interface
     */
    public void run(){
        System.out.println("Welcome to the HR System");
        SystemController inOut = new SystemController();// define a SystemController which takes call method and return message based on user input
        String input;
        do{// repeated running the InOutHandler while the input is not exit
            // display the menu option for user
            System.out.println("Enter 1 followed by name, salary, department, day of the week, start time, end time of the schedule each separated by a space to create a new worker");
            System.out.println("Enter 2 followed by name, department, number of year of experience each separated by a space to create a department head");
            System.out.println("Enter 3 followed by the id of the worker and the percent you want to change the salary by (positive means increase, negative means decrease) each separated by a space to change salary of a worker");
            System.out.println("Enter 4 followed by the id of the worker and the new day of week, start time and end time of the new schedule each separated by a space to change schedule of a worker");
            System.out.println("Enter 5 followed by the id of the worker that want to be deleted separated by a space to delete a worker from the system");
            System.out.println("Enter 6 followed by the id of the department head that want to be deleted separated by a space to delete a department head from the system");
            System.out.println("Enter 7 followed by the name of the worker that want to be searched separated by a space to search a worker with the given name from the system");
            System.out.println("Enter 8 followed by more if want to find department head with more years of experience than the given year, less if want to find department head with less years of experience and followed by the target year of experience separated by a space to search department head");
            System.out.println("Enter 9 to check all workers and department heads created");
            System.out.println("Enter exit to exit the system");
            System.out.println("Please enter what you want to do");
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            // produce the message that the user should see
            ArrayList<String> output = inOut.run(input);
            // display the output
            for(String out : output){
                System.out.println(out);
            }
        }while(!input.equals("exit"));
        System.out.println("Thanks for using HR System");
    }
}
