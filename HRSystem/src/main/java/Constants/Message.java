package Constants;
import java.util.*;
public class Message {
    /**
     * return the welcome message
     * @return the welcome message that the user should see
     */
    public String getWelcomeMessage(){
        return "Welcome to the HR System";
    }

    /**
     * return the option menu that the user should see
     * @return the option menu as an arraylist
     */
    public ArrayList<String> getOptionMenu(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Enter 1 followed by name, salary, department, day of the week, start time, end time of the schedule each separated by a space to create a new worker");
        messages.add("Enter 2 followed by name, department, number of year of experience each separated by a space to create a department head");
        messages.add("Enter 3 followed by the id of the worker and the percent you want to change the salary by (positive means increase, negative means decrease) each separated by a space to change salary of a worker");
        messages.add("Enter 4 followed by the id of the worker and the new day of week, start time and end time of the new schedule each separated by a space to change schedule of a worker");
        messages.add("Enter 5 followed by the id of the worker that want to be deleted separated by a space to delete a worker from the system");
        messages.add("Enter 6 followed by the id of the department head that want to be deleted separated by a space to delete a department head from the system");
        messages.add("Enter 7 followed by either \"name\" to search for a worker by name or \"id\" to search for a worker with their id number followed by the name or id to search, separated by a space (case sensitive).");
        messages.add("Enter 8 followed by either \"id\" to search for a department head with the id or \"year\" to find department head with more years of experience than the given year followed by the target year of experience separated by a space to search department head");
        messages.add("Enter 9 to check all workers and department heads created");
        messages.add("Enter 10 to undo the previous operation to worker");
        messages.add("Enter 11 to undo the previous operation to department head");
        messages.add("Enter exit to exit the system");
        messages.add("Please enter what you want to do");
        return messages;
    }

    /**
     * return the ending or the thanks for using message
     * @return the ending or the thanks for using message
     */
    public String getThanksMessage(){
        return "Thanks for using HR System";
    }

    /**
     * return the invalid input message
     * @return the invalid input message
     */
    public String getInvalidInputMessage(){
        return "Invalid input, please try again";
    }

    /**
     * return no worker match in the system message
     * @return the message that the user should see if no worker match in the system
     */
    public String getNoMatchWorkerMessage(){
        return "the given worker ID doesn't match with an ID in the system";
    }

    /**
     * return no department head match in the system message
     * @return the message that the user should see if no department head match in the system
     */
    public String getNoMatchHeadMessage(){
        return "no department head found with the given ID";
    }

    /**
     * return the exit message
     * @return the exit message
     */
    public String getExitMessage(){
        return "System exited";
    }

    /**
     * return the no worker found with name message
     * @return the message that the user should see if no worker found with the name
     */
    public String getNoWorkerNameMessage(){
        return "No worker found with the given name";
    }

    /**
     * return the no worker found with ID message
     * @return the message that the user should see if no worker found with the ID
     */
    public String getNoWorkerIDMessage(){
        return "No worker found with the given id";
    }

    /**
     * return the no department head with more years of experience
     * @return the message that the user should see if no department head has more years of experience then the given year
     */
    public String getNoHeadYearMessage(){
        return "No department head has more years of experience than the given years of experience";
    }

    /**
     * return the no department head found with ID message
     * @return the message that the user should see if no department head found with the ID
     */
    public String getNoHeadIDMessage(){
        return "No department head found with the given id";
    }

    /**
     * return the connecting text for create worker operations
     * @return the connecting text for create worker operations
     */
    public ArrayList<String> getCreateWorkerMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("worker ");
        messages.add(" with id ");
        messages.add(", salary ");
        messages.add(" department ");
        messages.add(" is created");
        return messages;
    }

    /**
     * return the connecting text for create department head operations
     * @return the connecting text for create department head operations
     */
    public ArrayList<String> getCreateHeadMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("department head ");
        messages.add(" with id ");
        messages.add(", department ");
        messages.add(" and ");
        messages.add(" years of experience is created");
        return messages;
    }

    /**
     * return the connecting text for change salary operations
     * @return the connecting text for change salary operations
     */
    public ArrayList<String> getChangeSalaryMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("the salary of ");
        messages.add(" with id ");
        messages.add(" has been changed to ");
        return messages;
    }

    /**
     * return the connecting text for change schedule operations
     * @return the connecting text for change schedule operations
     */
    public ArrayList<String> getChangeScheduleMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("schedule changed for ");
        messages.add(" with id ");
        messages.add(" in ");
        messages.add(" department with current schedule on ");
        messages.add(" from ");
        messages.add(" to ");
        return messages;
    }

    /**
     * return the connecting text for delete worker operations
     * @return the connecting text for delete worker operations
     */
    public ArrayList<String> getDeleteWorkerMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("worker with id ");
        messages.add(" is deleted from system");
        return messages;
    }

    /**
     * return the connecting text for delete department head operations
     * @return the connecting text for delete department head operations
     */
    public ArrayList<String> getDeleteHeadMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("department head with id ");
        messages.add(" is deleted from system");
        return messages;
    }

    /**
     * return the connecting text for listing workers
     * @return the connecting text for listing workers
     */
    public ArrayList<String> getListWorkerMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("worker ");
        messages.add(" with id ");
        messages.add(" in department ");
        messages.add(" with salary ");
        messages.add(" and schedule on ");
        messages.add(" from ");
        messages.add(" to ");
        return messages;
    }

    /**
     * return the connecting text for listing department heads
     * @return the connecting text for listing department heads
     */
    public ArrayList<String> getListHeadMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("department head ");
        messages.add(" with ID ");
        messages.add(" in department ");
        messages.add(" with ");
        messages.add(" years of experience");
        return messages;
    }

    /**
     * return that the undo successful message
     * @return the successful undo message
     */
    public String getUndoSuccessMessage(){
        return "Your previous operations have been undone";
    }

    /**
     * return that the undo is not successful message
     * @return the not successful undo message
     */
    public String getNotUndoableMessage(){
        return "Your previous operations have no affect on the system but they are still been undone";
    }

    /**
     * return that no previous command message
     * @return the no previous command message
     */
    public String getNoPreviousCommandMessage(){
        return "There is no previous command";
    }
}
