package DepartmentHeadOperations;

import Entities.DepartmentHead;
import Data.*;
import java.io.IOException;
import java.util.ArrayList;
import Constants.*;
public class DepartmentHeadManager {

    final private ArrayList<DepartmentHead> heads;
    private int nextHeadID;
    ReadWriter readWriter;
    FileName headFile = new FileName();
    /**
     * Constructor of DepartmentHeadManager
     * @param readWriter the readWriter that is used to read and write list of department heads to the ser file
     * @param test true when this is used for testing and false when this is used for running program
     */
    public DepartmentHeadManager(DepartmentHeadReadWriter readWriter, boolean test) throws IOException, ClassNotFoundException {
        // initialize the readWrite to the given readWriter
        this.readWriter = readWriter;
        // store the list of department heads from the ser file to the list of all department heads
        if(test){this.heads = readWriter.readFromFile(headFile.headTestFileName());}
        else{this.heads = readWriter.readFromFile(headFile.headRunFileName());}
        // the next department head id is either initialize to 0 if there is no record in the file
        // or to the largest department head ID in the ser file plus 1
        this.nextHeadID = -1;
        if(heads.isEmpty()){
            this.nextHeadID = 0;
        }else {
            for (DepartmentHead head : heads) {
                if (head.getID() > this.nextHeadID) {
                    this.nextHeadID = head.getID();
                }
            }
            this.nextHeadID += 1;
        }
    }

    /**
     * create a new department head
     * @param name the name of the department head
     * @param department the department of the department head
     * @param yearOfExperience the number of years of experience the department head has
     * @param test true when this is used for testing and false when this is used for running program
     * @return the information needed to form output
     */
    public ArrayList<String> createDepartmentHead(String name, String department, int yearOfExperience, boolean test) throws IOException {
        // create a new department head with the constructor and add it to the list of department head
        this.heads.add(new DepartmentHead(name, this.nextHeadID, department, yearOfExperience));
        // write the new list of department heads to the ser file
        if(test){readWriter.saveToFile(headFile.headTestFileName(), heads);}
        else{readWriter.saveToFile(headFile.headRunFileName(), heads);}
        // return the message that the user should see
        ArrayList<String> output =  new ArrayList<>();
        output.add(name + " " + this.nextHeadID + " " + department + " "
                + yearOfExperience);
        // increment next available ID by 1
        this.nextHeadID += 1;
        return output;
    }

    /**
     * delete a department head given the ID
     * @param headID the department head id that wants to be deleted
     * @param test true when this is used for testing and false when this is used for running program
     * @return the information needed to form output
     */
    public ArrayList<String> deleteHead(int headID, boolean test) throws IOException {
        ArrayList<String> output =  new ArrayList<>();
        for(DepartmentHead head : this.heads){
            if(head.getID() == headID){// get the department head wanted to be deleted
                output.add(head.getName() + " " + head.getID() + " " + head.getDepartment() + " " + head.getYearOfExperience());
                this.heads.remove(head);// remove the department head from the list and return the message
                if(test){readWriter.saveToFile(headFile.headTestFileName(), heads);}
                else{readWriter.saveToFile(headFile.headRunFileName(), heads);}// write the new list to ser file
                output.add("S " + head.getName() + " " + head.getID() + " " + head.getDepartment() + " " + head.getYearOfExperience());
                return output;
            }
        }
        // if no department head found, return symbol for no department head found
        output.add("N I");
        return output;
    }

    /**
     * return the information of list of department head match the given condition
     * @param yearOfExperience the target year of experience that want to look for
     * @return the information needed to form output
     */
    public ArrayList<String> searchByExperienceYear(int yearOfExperience){
        ArrayList<String> headWithByExperienceYear = new ArrayList<>();
        for(DepartmentHead head: this.heads){
            if (head.getYearOfExperience() >= yearOfExperience){ // we wound the head with the given ID
                headWithByExperienceYear.add(head.getName() + " " + head.getID() + " " + head.getDepartment() +" " + head.getYearOfExperience());
            }
        }
        if(headWithByExperienceYear.isEmpty()) {// if there is no department head satisfy the condition, then return symbol for no department head match
            headWithByExperienceYear.add("F");

        }
        return headWithByExperienceYear;
    }

    /**
     * return the list of department head's information with the given name
     * @param id the department head's name that we want to search
     * @return the information needed to form output
     */
    public ArrayList<String> searchByID(int id){
        ArrayList<String> headWithID = new ArrayList<>();
        for(DepartmentHead head: this.heads){
            if (head.getID() == id){ // we wound the head with the given ID
                headWithID.add(head.getName() + " " + head.getID() + " " + head.getDepartment() +" " + head.getYearOfExperience());
            }
        }
        if(headWithID.isEmpty()) {// if there is no department head satisfy the condition, then return symbol for no department head match
            headWithID.add("f");

        }
        return headWithID;
    }

    /**
     * return the information of list of all department heads
     * @return the information needed to form output
     */
    public ArrayList<String> allHeads(){
        ArrayList<String> out = new ArrayList<>();
        for(DepartmentHead head : this.heads){
            // convert all department head information to string and add it to the output list
            out.add(head.getName() + " " + head.getID() + " " + head.getDepartment() + " " + head.getYearOfExperience());
        }
        return out;
    }

    /**
     * Delete all department heads in the file
     * @param test true when this is used for testing and false when this is used for running program
     */
    public void deleteAllHead(boolean test) throws IOException {
        if(test){readWriter.saveToFile(headFile.headTestFileName(), new ArrayList<>());}
        else{readWriter.saveToFile(headFile.headRunFileName(), new ArrayList<>());}
    }

    /**
     * undo create department head
     * @param test true when this is used for testing and false when this is used for running program
     */
    public void undoCreateDepartmentHead(boolean test) throws IOException {
        this.deleteHead((this.nextHeadID - 1), test);
        if(test){readWriter.saveToFile(headFile.headTestFileName(), heads);}
        else{readWriter.saveToFile(headFile.headRunFileName(), heads);}
        this.nextHeadID -= 1;
    }

    /**
     * undo delete department head
     * @param arguments information about the deleted worker
     * @param test true when this is used for testing and false when this is used for running program
     */
    public void undoDeleteHead(ArrayList<String> arguments,  boolean test) throws IOException {
        DepartmentHead head = new DepartmentHead(arguments.get(0), Integer.parseInt(arguments.get(1)), arguments.get(2), Integer.parseInt(arguments.get(3)));
        this.heads.add(head);
        if(test){readWriter.saveToFile(headFile.headTestFileName(), heads);}
        else{readWriter.saveToFile(headFile.headRunFileName(), heads);}
    }
}
