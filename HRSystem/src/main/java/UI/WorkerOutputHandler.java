package UI;

import Constants.Message;

import java.util.ArrayList;

public class WorkerOutputHandler {
    /**
     * display outputs that user should see based on information given from controller
     * @param operations indicates what operations has been performed
     * @param info information needed to form specific output
     */
    public void display(String operations, ArrayList<String> info){
        Message m = new Message();
        ArrayList<String> messages;
        switch(operations){
            case "create worker":
                String [] information = info.get(0).split(" ");
                messages = m.getCreateWorkerMessage();
                System.out.println(messages.get(0) + information[0] +  messages.get(1) + information[1] + messages.get(2) + information[2] + messages.get(3) + information[3] + messages.get(4));
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
                    System.out.println(messages.get(0) + idInfo[2] + messages.get(1));
                }else{
                    System.out.println(m.getNoMatchWorkerMessage());
                }
                break;
            case "undo":
                if(info.get(0).equals("U")){
                    System.out.println(m.getUndoSuccessMessage());
                }else if(info.get(0).equals("NU")){
                    System.out.println(m.getNotUndoableMessage());
                }else{
                    System.out.println(m.getNoPreviousCommandMessage());
                }
                break;
            case "exit":
                System.out.println(m.getExitMessage());
                break;
            case "list":
                if(info.size() == 1 && info.get(0).split(" ").length == 1){
                    if(info.get(0).equals("f")){
                        System.out.println(m.getNoWorkerNameMessage());
                    }else if(info.get(0).equals("F")) {
                        System.out.println(m.getNoWorkerIDMessage());
                    }
                    else {
                        System.out.println(m.getInvalidInputMessage());
                    }
                }else {
                    for (String out : info) {
                        String[] attributes = out.split(" ");
                        messages = m.getListWorkerMessage();
                        System.out.println(messages.get(0) + attributes[0] + messages.get(1) + attributes[1] + messages.get(2) + attributes[2] + messages.get(3) + attributes[3] + messages.get(4) + attributes[4] +  messages.get(5) + attributes[6] + messages.get(6) + attributes[8]);
                    }
                }
                break;
            default:
                System.out.println(m.getInvalidInputMessage());
                break;
        }
    }
}
