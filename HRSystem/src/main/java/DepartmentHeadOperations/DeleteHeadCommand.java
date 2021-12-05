package DepartmentHeadOperations;


import java.io.IOException;
import java.util.ArrayList;

public class DeleteHeadCommand implements HeadCommands {

    private ArrayList<String> arguments;

    public DeleteHeadCommand(ArrayList<String> arguments){
        this.arguments = arguments;
    }
    /**
     * execute the delete department head command by calling the deleteHead method in use case class and change arguments to allow undo
     * @param manager the use case class that contains the deleteHead method
     * @return the information needed to form output
     */
    @Override
    public ArrayList<String> execute(DepartmentHeadManager manager) throws IOException {
        ArrayList<String> out = manager.deleteHead(Integer.parseInt(this.arguments.get(0)),false);
        if(out.get(0).equals("N I")){
            // This is when no department heads are deleted so set
            // the arguments to output which indicates that don't modify the file when undo
            this.arguments = out;
        }else{
            // when the department heads are deleted, then change the arguments of this command object
            // to allow undo
            String info = out.remove(0);
            String [] in = info.split(" ");
            ArrayList<String> newArg = new ArrayList<>();
            newArg.add(in[0]);// name of department head deleted
            newArg.add(in[1]);// ID of department head deleted
            newArg.add(in[2]);// department of department head deleted
            newArg.add(in[3]);// years of experience of department head deleted
            this.arguments = newArg;
        }
        return out;
    }

    /**
     * undo delete department head command by calling the undo delete department head method in use case class with arguments which is information of the department head deleted
     * @param manager the use case class that contains the undo delete department head method
     * @return the informatino needed to form output
     */
    @Override
    public ArrayList<String> undo(DepartmentHeadManager manager) throws IOException{
        if(this.arguments.get(0).equals("N I")){
            // If the delete department head is not successful, don't call methods in use case
            ArrayList<String> output = new ArrayList<>();
            output.add("NU"); // indicates this undo has no affect on program record
            return output;
        }
        // If the delete department head is successful, call the undo method with the deleted department head information
        manager.undoDeleteHead(this.arguments, false);
        ArrayList<String> output = new ArrayList<>();
        output.add("U");// undo successful
        return output;
    }
}
