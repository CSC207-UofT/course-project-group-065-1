package Constants;
import java.util.*;
public class Message {
    public String getWelcomeMessage(){
        return "Welcome to the HR System";
    }

    public ArrayList<String> getOptionMenu(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Enter 1 followed by name, salary, department, day of the week, start time, end time of the schedule each separated by a space to create a new worker");
        messages.add("Enter 2 followed by name, department, number of year of experience each separated by a space to create a department head");
        messages.add("Enter 3 followed by the id of the worker and the percent you want to change the salary by (positive means increase, negative means decrease) each separated by a space to change salary of a worker");
        messages.add("Enter 4 followed by the id of the worker and the new day of week, start time and end time of the new schedule each separated by a space to change schedule of a worker");
        messages.add("Enter 5 followed by the id of the worker that want to be deleted separated by a space to delete a worker from the system");
        messages.add("Enter 6 followed by the id of the department head that want to be deleted separated by a space to delete a department head from the system");
        messages.add("Enter 7 followed by either \"name\" to search for a worker by name or \"id\" to search for a worker with their id number followed by the name or id to search, separated by a space (case sensitive).");
        messages.add("Enter 8 followed by more if want to find department head with more years of experience than the given year, less if want to find department head with less years of experience and followed by the target year of experience separated by a space to search department head");
        messages.add("Enter 9 to check all workers and department heads created");
        messages.add("Enter 10 to undo the previous operation to worker");
        messages.add("Enter 11 to undo the previous operation to department head");
        messages.add("Enter exit to exit the system");
        messages.add("Please enter what you want to do");
        return messages;
    }

    public String getThanksMessage(){
        return "Thanks for using HR System";
    }

    public String getInvalidInputMessage(){
        return "Invalid input, please try again";
    }

    public String getNoMatchWorkerMessage(){
        return "the given worker ID doesn't match with an ID in the system";
    }

    public String getNoMatchHeadMessage(){
        return "no department head found with the given ID";
    }

    public String getExitMessage(){
        return "System exited";
    }

    public String getNoWorkerNameMessage(){
        return "No worker found with the given name";
    }

    public String getNoWorkerIDMessage(){
        return "No worker found with the given id";
    }

    public String getNoHeadMatchMessage(){
        return "No department head match the condition";
    }

    public ArrayList<String> getCreateWorkerMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("worker ");
        messages.add(" with id ");
        messages.add(", salary ");
        messages.add(" department ");
        messages.add(" is created");
        return messages;
    }

    public ArrayList<String> getCreateHeadMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("department head ");
        messages.add(" with id ");
        messages.add(", department ");
        messages.add(" and ");
        messages.add(" years of experience is created");
        return messages;
    }

    public ArrayList<String> getChangeSalaryMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("the salary of ");
        messages.add(" with id ");
        messages.add(" has been changed to ");
        return messages;
    }

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

    public ArrayList<String> getDeleteWorkerMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("worker with id ");
        messages.add(" is deleted from system");
        return messages;
    }

    public ArrayList<String> getDeleteHeadMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("department head with id ");
        messages.add(" is deleted from system");
        return messages;
    }

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

    public ArrayList<String> getListHeadMessage(){
        ArrayList<String> messages = new ArrayList<>();
        messages.add("department head ");
        messages.add(" with ID ");
        messages.add(" in department ");
        messages.add(" with ");
        messages.add(" years of experience");
        return messages;
    }

    public String getUndoSuccessMessage(){
        return "Your previous operations have been undone";
    }

    public String getNotUndoableMessage(){
        return "Your previous operations have no affect on the system but they are still been undone";
    }

    public String getNoPreviousCommandMessage(){
        return "There is no previous command";
    }
}
