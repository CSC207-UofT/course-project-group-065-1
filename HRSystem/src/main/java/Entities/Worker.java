package Entities;


import java.io.Serializable;

public class Worker extends Employees implements Serializable {
    private double salary;
    private final Schedule schedule;

    /**
     * constructor for worker
     * @param name the name of the worker
     * @param salary the salary of the worker
     * @param ID the ID of the worker
     * @param department the department of the worker
     * @param schedule the schedule of the worker
     */

    public Worker(String name, double salary, int ID, String department, Schedule schedule){
        super(name, ID, department);
        this.salary = salary;
        this.schedule = schedule;
    }

    /**
     * get the salary of the worker
     * @return the salary of the worker
     */
    public double getSalary(){
        return this.salary;
    }

    /**
     * set the salary of the worker to the given salary
     * @param salary the target salary that want to be set
     */
    public void setSalary(double salary){
        this.salary = salary;
    }

    /**
     * set the schedule of the worker
     * @param dayOfWeek the target day of week that want to be set
     * @param startTime the target start time that want to be set
     * @param endTime the target end time that want to be set
     */
    public void setSchedule(String dayOfWeek, String startTime, String endTime){
        this.schedule.setDayOfWeek(dayOfWeek);
        this.schedule.setStartTime(startTime);
        this.schedule.setEndTime(endTime);
    }

    /**
     * get the schedule of the worker
     * @return the schedule of the worker
     */
    public Schedule getSchedule(){
        return this.schedule;
    }

    /**
     * return the string representation of worker
     * @return the string representation of worker
     */
    @Override
    public String toString(){
        return "worker " + this.getName() + " with id " + this.getID() + " in department " + this.getDepartment() + " with salary " + this.salary + " and schedule on " + this.schedule.toString();
    }
}
