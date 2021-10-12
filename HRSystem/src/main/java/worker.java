public class worker {
    private final String name;
    private double salary;
    private final int ID;
    private final String department;
    private final schedule schedule;

    public worker(String name, int salary, int ID, String department, schedule schedule){
        this.name = name;
        this.salary = salary;
        this.ID = ID;
        this.department = department;
        this.schedule = schedule;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public int getID(){
        return this.ID;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public void setSchedule(String dayOfWeek, String startTime, String endTime){
        this.schedule.setDayOfWeek(dayOfWeek);
        this.schedule.setStartTime(startTime);
        this.schedule.setEndTime(endTime);
    }

    public schedule getSchedule(){
        return this.schedule;
    }
}
