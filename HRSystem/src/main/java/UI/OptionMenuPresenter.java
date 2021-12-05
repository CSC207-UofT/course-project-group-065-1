package UI;

import Constants.Message;

public class OptionMenuPresenter {

    /**
     * display the option menu that the user should see
     */
    public void display() {
        Message m = new Message();
        for(String message : m.getOptionMenu()){
            System.out.println(message);
        }
    }
}
