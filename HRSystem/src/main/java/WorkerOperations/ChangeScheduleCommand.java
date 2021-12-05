package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeScheduleCommand implements WorkerCommands {
    private ArrayList<String> arguments;

    public ChangeScheduleCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the change schedule commands and change arguments to allow undo
     * @param manager the use case class that contains methods that is needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        ArrayList<String> out = manager.changeSchedule(this.arguments,false);
        if(out.get(0).equals("N I")){// change is not successful
            this.arguments = out;
        }else{
            String info = out.remove(0);
            String [] in = info.split(" ");
            ArrayList<String> newArg = new ArrayList<>();
            newArg.add(this.arguments.get(0));
            newArg.add(in[0]);// update arguments
            newArg.add(in[2]);
            newArg.add(in[4]);
            this.arguments = newArg;
        }
        return out;
    }

    /**
     * undo the change schedule command
     * @param manager the use case class that contains methods that is needed to undo the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> undo(WorkerManager manager) throws IOException {
        if(this.arguments.get(0).equals("N I")){// if change is not successful, then return undo doesn't change anything in program
            ArrayList<String> output = new ArrayList<>();
            output.add("NU");
            return output;
        }
        manager.changeSchedule(this.arguments, false);
        ArrayList<String> output = new ArrayList<>();
        output.add("U");// undo is successful
        return output;
    }
}
