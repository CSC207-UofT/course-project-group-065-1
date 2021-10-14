import java.util.*;
public class workerManager {
    public String createWorker(String name, int salary, int ID, departmentHead head, String dayOfWeek, String startTime, String endTine){
        worker newWorker = new worker(name, salary, ID, head.getDepartment(), new schedule(dayOfWeek, startTime, endTine));
        ArrayList<worker> currentWorker = head.getWorkerInDepart();
        currentWorker.add(newWorker);
        head.setWorkerInDepart(currentWorker);
        return "worker " + newWorker.getName() + " with id " + newWorker.getID() + ", salary " + newWorker.getSalary() +
                " and department " + newWorker.getDepartment() + " is created";
    }

    public String changeSalary(int workerID, departmentHead head, double changePercent){
        ArrayList<worker> workers = head.getWorkerInDepart();
        for(worker worker : workers){
            if(worker.getID() == workerID){
                worker.setSalary(worker.getSalary() + worker.getSalary()*changePercent);
                return "the salary of " + worker.getName() + " with id " + worker.getID() + " has been changed to "
                        + worker.getSalary() + " by permission from " + head.getName();
            }
        }
        return "department head has no right to change salary for the worker";
    }

    public String changeSchedule(int workerID, departmentHead head, String dayOfWeek, String startTime, String endTime){
        ArrayList<worker> workers = head.getWorkerInDepart();
        for(worker worker : workers){
            if(worker.getID() == workerID){
                worker.setSchedule(dayOfWeek, startTime, endTime);
                return "schedule changed for " + worker.getName() + " with id " + worker.getID() + " in " +
                        worker.getDepartment() + " department with current schedule on " + worker.getSchedule().toString();
            }
        }
        return "department head has no right to change schedule";
    }
}
