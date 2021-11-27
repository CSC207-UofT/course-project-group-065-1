package UI;

import Constants.Message;

public class OptionMenuPresenter {

    public void display() {
        Message m = new Message();
        for(String message : m.getOptionMenu()){
            System.out.println(message);
        }
    }
}
