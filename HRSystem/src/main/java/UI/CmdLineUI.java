package UI;


import java.io.IOException;
import java.util.*;
public class CmdLineUI {
    /**
     * run the command line user interface
     */
    public void run() throws IOException, ClassNotFoundException {
        System.out.println("Welcome to the HR System");
        SystemController inOut = new SystemController();// define a web.SystemController which takes call method and return message based on user input
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
            String operations = output.remove(0);
            displayOutput(operations, output);
        }while(!input.equals("exit"));
        System.out.println("Thanks for using HR System");
    }

    /**
     * helper function for the run which display output based on controller output
     * @param operations the operations being performed
     * @param info the key information needed to form output
     */
    private void displayOutput(String operations, ArrayList<String> info){
        switch(operations){
            case "create worker":
                String [] information = info.get(0).split(" ");
                System.out.println("worker " + information[0] + " with id " + information[1] + ", salary " + information[2] + " department " + information[3] + " is created");
                break;
            case "create head":
                String [] headInformation = info.get(0).split(" ");
                System.out.println("department head " + headInformation[0] + " with id " + headInformation[1] + ", department " + headInformation[2] + " and "
                        + headInformation[3] + " years of experience is created");
                break;
            case "change salary":
                String [] salaryInfo = info.get(0).split(" ");
                if(salaryInfo[0].equals("S")) {
                    System.out.println("the salary of " + salaryInfo[1] + " with id " + salaryInfo[2] + " has been changed to "
                            + salaryInfo[3]);
                }else{
                    System.out.println("the given worker ID doesn't match with an ID in the system");
                }
                break;
            case "change schedule":
                String [] scheduleInfo = info.get(0).split(" ");
                if(scheduleInfo[0].equals("S")) {
                    System.out.println("schedule changed for " + scheduleInfo[1] + " with id " + scheduleInfo[2] + " in " +
                            scheduleInfo[3] + " department with current schedule on " + scheduleInfo[4] + " from " + scheduleInfo[6] + " to " + scheduleInfo[8]);
                }else{
                    System.out.println("the given worker ID doesn't match with an ID in the system");
                }
                break;
            case "delete worker":
                String [] idInfo = info.get(0).split(" ");
                if(idInfo[0].equals("S")) {
                    System.out.println("worker with id " + idInfo[1] + " is deleted from system");
                }else{
                    System.out.println("worker ID not found");
                }
                break;
            case "delete head":
                String [] headIdInfo = info.get(0).split(" ");
                if(headIdInfo[0].equals("S")) {
                    System.out.println("department head with id " + headIdInfo[1] + " is deleted from the system");
                }else{
                    System.out.println("no department head found with the given ID");
                }
                break;
            case "exit":
                System.out.println("System exited");
                break;
            case "list":
                if(info.size() == 1 && (info.get(0).split(" ")[0].equals("F") || info.get(0).split(" ")[0].equals("I"))){
                    if(info.get(0).equals("F")){
                        System.out.println("No worker found with the given name");
                    }else if(info.get(0).equals("I")) {
                        System.out.println("Incorrect input, please try again");
                    }else{
                        if(info.get(0).split(" ")[1].equals("M")){
                            System.out.println("No department head found in the system with year of experience more than " + info.get(0).split(" ")[2]);
                        }else{
                            System.out.println("No department head found in the system with year of experience less than " + info.get(0).split(" ")[2]);
                        }
                    }
                }else {
                    for (String out : info) {
                        String[] attributes = out.split(" ");
                        if (attributes.length == 9) {
                            System.out.println("worker " + attributes[0] + " with id " + attributes[1] + " in department " + attributes[2] + " with salary " + attributes[3] + " and schedule on " + attributes[4] +  " from " + attributes[6] + " to " + attributes[8]);
                        } else {
                            System.out.println("department head " + attributes[0] + " with ID " + attributes[1] + " in department " + attributes[2] + " with " + attributes[3] + " years of experience");
                        }
                    }
                }
                break;
            default:
                System.out.println("Incorrect command entered, please try again");
                break;
        }
    }
}
