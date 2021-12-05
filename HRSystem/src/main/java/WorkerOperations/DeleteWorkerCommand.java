package WorkerOperations;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteWorkerCommand implements WorkerCommands {
    private ArrayList<String> arguments;

    public DeleteWorkerCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the delete worker command and change arguments to allow undo
     * @param manager the use case class that contains methods that is needed to execute the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(WorkerManager manager) throws IOException {
        ArrayList<String> out = manager.deleteWorker(Integer.parseInt(this.arguments.get(0)),false);
        if(out.get(0).equals("N I")){
            this.arguments = out;
        }else{
            String info = out.remove(0);
            String [] in = info.split(" ");
            ArrayList<String> newArg = new ArrayList<>();
            newArg.add(in[0]);
            newArg.add(in[1]);
            newArg.add(in[2]);
            newArg.add(in[3]);
            newArg.add(in[4]);
            newArg.add(in[6]);
            newArg.add(in[8]);
            this.arguments = newArg;
        }
        return out;
    }

    /**
     * undo the delete worker command
     * @param manager the use case class that contains methods that is needed to undo the command
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> undo(WorkerManager manager) throws IOException{
        if(this.arguments.get(0).equals("N I")){
            ArrayList<String> output = new ArrayList<>();
            output.add("NU");
            return output;
        }
        manager.undoDeleteWorker(this.arguments, false);
        ArrayList<String> output = new ArrayList<>();
        output.add("U");
        return output;
    }
}
