public class employees {
    private final String name;
    private final int ID;
    private final String department;

    /**
     * constructor for employee
     * @param name name of the employee
     * @param ID the ID of the employee
     * @param department the department of the employee
     */

    public employees(String name, int ID, String department){
        this.name = name;
        this.ID = ID;
        this.department = department;
    }

    /**
     * getter for getting the employee name
     * @return the name of the employee
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter for getting the employee ID
     * @return the ID of the employee
     */
    public int getID(){
        return this.ID;
    }

    /**
     * getter for getting the department of the employee
     * @return the department of the employee
     */
    public String getDepartment(){
        return this.department;
    }
}
