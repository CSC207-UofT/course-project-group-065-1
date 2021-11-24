package UI;


import java.io.IOException;
import java.util.*;
import Constants.*;
public class CmdLineUI {
    /**
     * run the command line user interface
     */
    public void run() throws IOException, ClassNotFoundException {
        Message m = new Message();
        System.out.println(m.getWelcomeMessage());
        SystemController inOut = new SystemController();// define a web.SystemController which takes call method and return message based on user input
        String input;
        do{// repeated running the InOutHandler while the input is not exit
            // display the menu option for user
            for(String message : m.getOptionMenu()){
                System.out.println(message);
            }
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            // produce the message that the user should see
            ArrayList<String> output = inOut.run(input);
            // display the output
            String operations = output.remove(0);
            displayOutput(operations, output);
        }while(!input.equals("exit"));
        System.out.println(m.getThanksMessage());
    }

    /**
     * helper function for the run which display output based on controller output
     * @param operations the operations being performed
     * @param info the key information needed to form output
     */
    private void displayOutput(String operations, ArrayList<String> info){
        Message m = new Message();
        ArrayList<String> messages;
        switch(operations){
            case "create worker":
                String [] information = info.get(0).split(" ");
                messages = m.getCreateWorkerMessage();
                System.out.println(messages.get(0) + information[0] +  messages.get(1) + information[1] + messages.get(2) + information[2] + messages.get(3) + information[3] + messages.get(4));
                break;
            case "create head":
                String [] headInformation = info.get(0).split(" ");
                messages = m.getCreateHeadMessage();
                System.out.println(messages.get(0) + headInformation[0] + messages.get(1) + headInformation[1] + messages.get(2) + headInformation[2] + messages.get(3)
                        + headInformation[3] + messages.get(4));
                break;
            case "change salary":
                String [] salaryInfo = info.get(0).split(" ");
                if(salaryInfo[0].equals("S")) {
                    messages = m.getChangeSalaryMessage();
                    System.out.println(messages.get(0) + salaryInfo[1] + messages.get(1) + salaryInfo[2] + messages.get(2)
                            + salaryInfo[3]);
                }else{
                    System.out.println(m.getNoMatchWorkerMessage());
                }
                break;
            case "change schedule":
                String [] scheduleInfo = info.get(0).split(" ");
                if(scheduleInfo[0].equals("S")) {
                    messages = m.getChangeScheduleMessage();
                    System.out.println(messages.get(0) + scheduleInfo[1] + messages.get(1) + scheduleInfo[2] + messages.get(2) +
                            scheduleInfo[3] + messages.get(3) + scheduleInfo[4] + messages.get(4) + scheduleInfo[6] + messages.get(5) + scheduleInfo[8]);
                }else{
                    System.out.println(m.getNoMatchWorkerMessage());
                }
                break;
            case "delete worker":
                String [] idInfo = info.get(0).split(" ");
                if(idInfo[0].equals("S")) {
                    messages = m.getDeleteWorkerMessage();
                    System.out.println(messages.get(0) + idInfo[1] + messages.get(1));
                }else{
                    System.out.println(m.getNoMatchWorkerMessage());
                }
                break;
            case "delete head":
                String [] headIdInfo = info.get(0).split(" ");
                if(headIdInfo[0].equals("S")) {
                    messages = m.getDeleteHeadMessage();
                    System.out.println(messages.get(0) + headIdInfo[1] + messages.get(1));
                }else{
                    System.out.println(m.getNoMatchHeadMessage());
                }
                break;
            case "exit":
                System.out.println(m.getExitMessage());
                break;
            case "list":
                if(info.size() == 1){
                    if(info.get(0).equals("f")){
                        System.out.println(m.getNoWorkerNameMessage());
                    }else if(info.get(0).equals("I")) {
                        System.out.println(m.getInvalidInputMessage());
                    }else{
                        System.out.println(m.getNoHeadMatchMessage());
                    }
                }else {
                    for (String out : info) {
                        String[] attributes = out.split(" ");
                        if (attributes.length == 9) {
                            messages = m.getListWorkerMessage();
                            System.out.println(messages.get(0) + attributes[0] + messages.get(1) + attributes[1] + messages.get(2) + attributes[2] + messages.get(3) + attributes[3] + messages.get(4) + attributes[4] +  messages.get(5) + attributes[6] + messages.get(6) + attributes[8]);
                        } else {
                            messages = m.getListHeadMessage();
                            System.out.println(messages.get(0) + attributes[0] + messages.get(1) + attributes[1] + messages.get(2) + attributes[2] + messages.get(3) + attributes[3] + messages.get(4));
                        }
                    }
                }
                break;
            default:
                System.out.println(m.getInvalidInputMessage());
                break;
        }
    }
}
