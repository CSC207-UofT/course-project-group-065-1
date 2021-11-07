import java.util.*;
public class WorkerManager {
    final private ArrayList<Worker> workers;
    private int nextWorkerID;

    /**
     * Constructor of WorkerManager
     */
    public WorkerManager(){
        this.workers = new ArrayList<>();
        this.nextWorkerID = 0;
    }

    /**
     * create the worker if the input are valid
     * @param name the name of the worker that want to create
     * @param salary the salary of the worker that want to create
     * @param department the department of the worker that want to create
     * @param dayOfWeek the day of the week of the worker's schedule
     * @param startTime the start time of the worker's schedule
     * @param endTime the end time of the worker's schedule
     * @return the output string that the user should see
     */
    public String CreateWorker(String name, int salary, String department, String dayOfWeek, String startTime, String endTime){
        this.workers.add(new Worker(name, salary, this.nextWorkerID, department, new Schedule(dayOfWeek, startTime, endTime)));
        this.nextWorkerID += 1;
        return "worker " + name + " with id " + (this.nextWorkerID - 1) + ", salary " + salary + " department " + department + " is created";
    }

    /**
     * change the salary of the given worker
     * @param workerID the ID of the worker
     * @param changePercent the percent that the salary change where positive mean increase and negative mean decrease
     * @return the message that the user should see
     */
    public String changeSalary(int workerID,  double changePercent){
       for(Worker worker : this.workers){
           if(worker.getID() == workerID){
               worker.setSalary(worker.getSalary() + worker.getSalary()*changePercent);
               return "the salary of " + worker.getName() + " with id " + worker.getID() + " has been changed to "
                       + worker.getSalary();
           }
       }
       return "the given worker ID doesn't match with an ID in the system";
    }

    /**
     * change the schedule of the given worker
     * @param workerID the ID of the worker
     * @param dayOfWeek the day of the week that the schedule should change to
     * @param startTime the start time that the schedule should change to
     * @param endTime the end time that the schedule should change to
     * @return the message the user should see
     */
    public String changeSchedule(int workerID, String dayOfWeek, String startTime, String endTime){
        for(Worker worker : this.workers){
            if(worker.getID() == workerID){
                worker.setSchedule(dayOfWeek, startTime, endTime);
                return "schedule changed for " + worker.getName() + " with id " + worker.getID() + " in " +
                        worker.getDepartment() + " department with current schedule on " + worker.getSchedule().toString();
            }
        }
        return "the given worker ID doesn't match with an ID in the system";
    }

    public String deleteWorker(int workerID){
        for(Worker worker : this.workers){
            if(worker.getID() == workerID){
                this.workers.remove(worker);
                return "worker with id " + workerID + " is deleted from system";
            }
        }
        return "worker ID not found";
    }

    public ArrayList<String> searchByName(String name){
        ArrayList<String> workerWithName = new ArrayList<>();
        for(Worker worker : this.workers){
            if(worker.getName().equals(name)){
                workerWithName.add(worker.toString());
            }
        }
        if(workerWithName.isEmpty()){
            workerWithName.add("No worker found with the given name");
        }
        return workerWithName;
    }
}

