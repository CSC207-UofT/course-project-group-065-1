public class employees {
    private final String name;
    private final int ID;
    private final String department;

    public employees(String name, int ID, String department){
        this.name = name;
        this.ID = ID;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public int getID(){
        return this.ID;
    }

    public String getDepartment(){
        return this.department;
    }
}
