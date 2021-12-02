package DepartmentHeadOperations;


import java.io.IOException;
import java.util.ArrayList;

public class DeleteHeadCommand implements HeadCommands {

    private ArrayList<String> arguments;

    public DeleteHeadCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the delete department head command by calling the deleteHead method in use case class
     * @param manager the use case class that contains the deleteHead method
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) throws IOException {
        ArrayList<String> out = manager.deleteHead(Integer.parseInt(this.arguments.get(0)),false);
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
            this.arguments = newArg;
        }
        return out;
    }

    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager) throws IOException{
        if(this.arguments.get(0).equals("N I")){
            ArrayList<String> output = new ArrayList<>();
            output.add("NU");
            return output;
        }
        manager.undoDeleteHead(this.arguments, false);
        ArrayList<String> output = new ArrayList<>();
        output.add("U");
        return output;
    }
}
