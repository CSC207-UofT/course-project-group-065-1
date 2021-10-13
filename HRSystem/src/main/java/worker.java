public class worker extends departmentHead{
    private double salary;
    private final schedule schedule;

    public worker(String name, int salary, int ID, String department, schedule schedule){
        super(name, ID, department);
        this.salary = salary;
        this.schedule = schedule;
    }

    public double getSalary(){
        return this.salary;
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
