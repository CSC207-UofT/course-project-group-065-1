package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeSalaryCommand implements WorkerCommands {
    private ArrayList<String> arguments;

    public ChangeSalaryCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the change salary command and modify the arguments to allow undo
     * @param manager the user class that contains methods to execute the change salary command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        ArrayList<String> out = manager.changeSalary(Integer.parseInt(this.arguments.get(0)), Double.parseDouble(this.arguments.get(1)), false);
        if(out.get(0).equals("N I")){
            this.arguments = out;
        }else{
            this.arguments.remove(1);
            this.arguments.add(out.remove(0));
        }
        return out;
    }

    /**
     * undo the change salary command with the undo method
     * @param manager the user class that contains methods to undo the change salary command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> undo(WorkerManager manager) throws IOException {
        if(this.arguments.get(0).equals("N I")){
            ArrayList<String> output = new ArrayList<>();
            output.add("NU");
            return output;
        }
        manager.undoChangeSalary(Integer.parseInt(this.arguments.get(0)), Double.parseDouble(this.arguments.get(1)), false);
        ArrayList<String> output = new ArrayList<>();
        output.add("U");
        return output;
    }
}
