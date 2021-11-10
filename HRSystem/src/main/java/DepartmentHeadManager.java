import java.util.ArrayList;

public class DepartmentHeadManager {

    final private ArrayList<DepartmentHead> heads;
    private int nextHeadID;

    /**
     * Constructor for department head manager
     */
    public DepartmentHeadManager(){
        // initialize the list of department head to an empty list which has no department head created
        this.heads = new ArrayList<>();
        // the next department head id initialize to 0
        this.nextHeadID = 0;
    }

    /**
     * create a new department head
     * @param name the name of the department head
     * @param department the department of the department head
     * @param yearOfExperience the number of years of experience the department head has
     * @return the message that user should see
     */
    public String createDepartmentHead(String name, String department, int yearOfExperience){
        // create a new department head with the constructor and add it to the list of department head
        this.heads.add(new DepartmentHead(name, this.nextHeadID, department, yearOfExperience));
        // increase the next department head id by 1
        this.nextHeadID += 1;
        // return the detail of the department head created
        return "department head " + name + " with id " + (this.nextHeadID - 1) + ", department " + department + " and "
                + yearOfExperience + " years of experience is created";
    }

    /**
     * delete a department head given the ID
     * @param headID the department head id that wants to be deleted
     * @return the message that the user should see
     */
    public String deleteHead(int headID){
        for(DepartmentHead head : this.heads){
            if(head.getID() == headID){// get the department head wanted to be deleted
                this.heads.remove(head);// remove the department head from the list and return the message
                return "department head with id " + headID + " is deleted from the system";
            }
        }
        // if no department head found, return message no department head found
        return "no department head found with the given ID";
    }

    /**
     * return the string representation of list of department head match the given condition
     * @param moreOrLess more indicates find department head more than the given experience year and less indicate the opposite
     * @param yearOfExperience the target year of experience that want to look for
     * @return the string representation of list of department head match the given condition
     */
    public ArrayList<String> searchByExperienceYear(String moreOrLess, int yearOfExperience){
        ArrayList<String> headWithYear = new ArrayList<>();
        if(moreOrLess.equals("more")){// if the user enter more, then look for department head with more than the given experience year
            for(DepartmentHead head : this.heads){
                if(head.getYearOfExperience() > yearOfExperience){
                    headWithYear.add(head.toString());
                }
            }
            if(headWithYear.isEmpty()){// if there is no department head satisfy the condition, then return no department head match
                headWithYear.add("No department head found in the system with year of experience more than " + yearOfExperience);
            }
        }else if(moreOrLess.equals("less")){// if the user enter less, then look for department head with less than the given experience year
            for(DepartmentHead head : this.heads){
                if(head.getYearOfExperience() < yearOfExperience){
                    headWithYear.add(head.toString());
                }
            }
            if(headWithYear.isEmpty()){// if there is no department head satisfy the condition, then return no department head match
                headWithYear.add("No department head found in the system with year of experience less than " + yearOfExperience);
            }
        }else{
            headWithYear.add("Incorrect input, please try again");
        }
        return headWithYear;
    }

    /**
     * return the string representation of list of all department heads
     * @return the string representation of list of all department heads
     */
    public ArrayList<String> allHeads(){
        ArrayList<String> out = new ArrayList<>();
        for(DepartmentHead head : this.heads){
            // convert all department head to string and add it to the output list
            out.add(head.toString());
        }
        return out;
    }
}
