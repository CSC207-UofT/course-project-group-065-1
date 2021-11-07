import java.util.ArrayList;

public class DepartmentHeadManager {

    final private ArrayList<DepartmentHead> heads;
    private int nextHeadID;

    public DepartmentHeadManager(){
        this.heads = new ArrayList<>();
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
        this.heads.add(new DepartmentHead(name, this.nextHeadID, department, yearOfExperience));
        this.nextHeadID += 1;
        return "department head " + name + " with id " + (this.nextHeadID - 1) + ", department " + department + " and "
                + yearOfExperience + " years of experience is created";
    }

    public String deleteHead(int headID){
        for(DepartmentHead head : this.heads){
            if(head.getID() == headID){
                this.heads.remove(head);
                return "department head with id " + headID + " is deleted from the system";
            }
        }
        return "no department head found with the given ID";
    }

    public ArrayList<String> searchByExperienceYear(String moreOrLess, int yearOfExperience){
        ArrayList<String> headWithYear = new ArrayList<>();
        if(moreOrLess.equals("more")){
            for(DepartmentHead head : this.heads){
                if(head.getYearOfExperience() > yearOfExperience){
                    headWithYear.add(head.toString());
                }
            }
            if(headWithYear.isEmpty()){
                headWithYear.add("No department head found in the system with year of experience more than " + yearOfExperience);
            }
        }else if(moreOrLess.equals("less")){
            for(DepartmentHead head : this.heads){
                if(head.getYearOfExperience() < yearOfExperience){
                    headWithYear.add(head.toString());
                }
            }
            if(headWithYear.isEmpty()){
                headWithYear.add("No department head found in the system with year of experience less than " + yearOfExperience);
            }
        }else{
            headWithYear.add("Incorrect input, please try again");
        }
        return headWithYear;
    }

    public ArrayList<String> allHeads(){
        ArrayList<String> out = new ArrayList<>();
        for(DepartmentHead head : this.heads){
            out.add(head.toString());
        }
        return out;
    }
}
