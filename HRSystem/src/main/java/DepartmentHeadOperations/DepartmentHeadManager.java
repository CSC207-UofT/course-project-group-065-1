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
     */
    public DepartmentHeadManager(DepartmentHeadReadWriter readWriter) throws IOException, ClassNotFoundException {
        // initialize the readWrite to the given readWriter
        this.readWriter = readWriter;
        // store the list of department heads from the ser file to the list of all department heads
        this.heads = readWriter.readFromFile(headFile.headRunFileName());
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
     * @return the information needed to form output
     */
    public ArrayList<String> createDepartmentHead(String name, String department, int yearOfExperience) throws IOException {
        // create a new department head with the constructor and add it to the list of department head
        this.heads.add(new DepartmentHead(name, this.nextHeadID, department, yearOfExperience));
        // write the new list of department heads to the ser file
        readWriter.saveToFile(headFile.headRunFileName(), heads);
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
     * @return the information needed to form output
     */
    public ArrayList<String> deleteHead(int headID) throws IOException {
        ArrayList<String> output =  new ArrayList<>();
        for(DepartmentHead head : this.heads){
            if(head.getID() == headID){// get the department head wanted to be deleted
                this.heads.remove(head);// remove the department head from the list and return the message
                readWriter.saveToFile(headFile.headRunFileName(), heads);// write the new list to ser file
                output.add("S " + headID);
                return output;
            }
        }
        // if no department head found, return symbol for no department head found
        output.add("N I");
        return output;
    }

    /**
     * return the information of list of department head match the given condition
     * @param moreOrLess more indicates find department head more than the given experience year and less indicate the opposite
     * @param yearOfExperience the target year of experience that want to look for
     * @return the information needed to form output
     */
    public ArrayList<String> searchByExperienceYear(String moreOrLess, int yearOfExperience){
        ArrayList<String> headWithYear = new ArrayList<>();
        if(moreOrLess.equals("more")){// if the user enter more, then look for department head with more than the given experience year
            for(DepartmentHead head : this.heads){
                if(head.getYearOfExperience() > yearOfExperience){
                    headWithYear.add(head.getName() + " " + head.getID() + " " + head.getDepartment() + " " + head.getYearOfExperience());
                }
            }
            if(headWithYear.isEmpty()){// if there is no department head satisfy the condition, then return symbol for no department head match
                headWithYear.add("F");
            }
        }else if(moreOrLess.equals("less")){// if the user enter less, then look for department head with less than the given experience year
            for(DepartmentHead head : this.heads){
                if(head.getYearOfExperience() < yearOfExperience){
                    headWithYear.add(head.getName() + " " + head.getID() + " " + head.getDepartment() + " " + head.getYearOfExperience());
                }
            }
            if(headWithYear.isEmpty()){// if there is no department head satisfy the condition, then return symbol for no department head match
                headWithYear.add("F");
            }
        }else{
            headWithYear.add("I");
        }
        return headWithYear;
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
}
