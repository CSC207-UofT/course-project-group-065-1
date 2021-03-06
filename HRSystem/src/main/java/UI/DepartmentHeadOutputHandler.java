package UI;

import Constants.Message;

import java.util.ArrayList;

public class DepartmentHeadOutputHandler {

    /**
     * display outputs that user should see based on information given from controller
     * @param operations indicates what operations has been performed
     * @param info information needed to form specific output
     */
    public void display(String operations, ArrayList<String> info){
        Message m = new Message();
        ArrayList<String> messages;
        switch(operations){
            case "create head":
                String [] headInformation = info.get(0).split(" ");
                messages = m.getCreateHeadMessage();
                System.out.println(messages.get(0) + headInformation[0] + messages.get(1) + headInformation[1] + messages.get(2) + headInformation[2] + messages.get(3)
                        + headInformation[3] + messages.get(4));
                break;
            case "delete head":
                String [] headIdInfo = info.get(0).split(" ");
                if(headIdInfo[0].equals("S")) {
                    messages = m.getDeleteHeadMessage();
                    System.out.println(messages.get(0) + headIdInfo[2] + messages.get(1));
                }else{
                    System.out.println(m.getNoMatchHeadMessage());
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
                    if(info.get(0).equals("I")) {
                        System.out.println(m.getInvalidInputMessage());
                    }else if(info.get(0).equals("F")){
                        System.out.println(m.getNoHeadYearMessage());
                    }else{
                        System.out.println(m.getNoHeadIDMessage());
                    }
                }else {
                    for (String out : info) {
                        String[] attributes = out.split(" ");
                        messages = m.getListHeadMessage();
                        System.out.println(messages.get(0) + attributes[0] + messages.get(1) + attributes[1] + messages.get(2) + attributes[2] + messages.get(3) + attributes[3] + messages.get(4));
                    }
                }
                break;
            default:
                System.out.println(m.getInvalidInputMessage());
                break;
        }
    }

}
