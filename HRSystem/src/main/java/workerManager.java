public class workerManager {
    public worker createWorker(String name, int salary, int ID, String department, String dayOfWeek, String startTime, String endTine){
        return new worker(name, salary, ID, department, new schedule(dayOfWeek, startTime, endTine));
    }

    public String increaseSalary(worker worker, departmentHead head, double increasePercent){
        if(worker.getDepartment().equals(head.getDepartment())){
            double current_salary = worker.getSalary();
            worker.setSalary(current_salary + current_salary * increasePercent);
            return "the salary of " + worker.getName() + " with id " + worker.getID() + " has been increased to "
                    + worker.getSalary() + " by permission from " + head.getName();
        }else{
            return "department head has no right to increase salary for the worker";
        }
    }

    public String decreaseSalary(worker worker, departmentHead head, double decreasePercent){
        if(worker.getDepartment().equals(head.getDepartment())){
            double current_salary = worker.getSalary();
            worker.setSalary(current_salary - current_salary * decreasePercent);
            return "the salary of " + worker.getName() + " with id " + worker.getID() + " has been decreased to "
                    + worker.getSalary() + " by permission from " + head.getName();
        }else{
            return "department head has no right to decrease salary for the worker";
        }
    }

    public String changeSchedule(worker worker, departmentHead head, String dayOfWeek, String startTime, String endTime){
        if(worker.getDepartment().equals(head.getDepartment())){
            worker.setSchedule(dayOfWeek, startTime, endTime);
            return "schedule changed for " + worker.getName() + " with id " + worker.getID() + " in " +
                    worker.getDepartment() + " department with current schedule on " + worker.getSchedule().toString();
        }else{
            return "no right to change schedule when the department head has a different department as the worker";
        }
    }
}
