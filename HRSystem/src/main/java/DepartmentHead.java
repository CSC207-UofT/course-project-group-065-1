public class DepartmentHead extends Employees{
    private final int YearOfExperience;

    /**
     * constructor for department head. Initialize the worker under the department head arraylist to empty (no worker)
     * @param name the name of the department head
     * @param ID the ID of the department head
     * @param department the department of the department head
     * @param YearOfExperience the number of year of experience
     */
    public DepartmentHead(String name, int ID, String department, int YearOfExperience) {
        super(name, ID, department);
        this.YearOfExperience = YearOfExperience;
    }

    public int getYearOfExperience(){
        return this.YearOfExperience;
    }

    @Override
    public String toString(){
        return "department head " + this.getName() + " with ID " + this.getID() + " in department " + this.getDepartment() + " with " + this.YearOfExperience + "years of experience";
    }
}
