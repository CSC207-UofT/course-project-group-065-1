import java.util.*;
public class WorkerManager {
    final private ArrayList<Worker> workers;
    private int nextWorkerID;

    /**
     * Constructor of WorkerManager
     */
    public WorkerManager(){
        // initialize the list of workers to empty
        this.workers = new ArrayList<>();
        // the next available id to 0
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
        // create a new worker with given information and add it to the list of worker
        this.workers.add(new Worker(name, salary, this.nextWorkerID, department, new Schedule(dayOfWeek, startTime, endTime)));
        // increase next available id by 1 and return detail of worker to user
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
           if(worker.getID() == workerID){// find the worker with the id and change their salary
               worker.setSalary(worker.getSalary() + worker.getSalary()*changePercent);
               return "the salary of " + worker.getName() + " with id " + worker.getID() + " has been changed to "
                       + worker.getSalary();
           }
       }
       // no worker with the given id, then return no worker found message
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
            if(worker.getID() == workerID){// find the worker with the id and change their schedule
                worker.setSchedule(dayOfWeek, startTime, endTime);
                return "schedule changed for " + worker.getName() + " with id " + worker.getID() + " in " +
                        worker.getDepartment() + " department with current schedule on " + worker.getSchedule().toString();
            }
        }
        // no worker with id, then return no worker found message
        return "the given worker ID doesn't match with an ID in the system";
    }

    /**
     * delete worker with given id
     * @param workerID the id of worker that want to delete
     * @return message that the user see
     */
    public String deleteWorker(int workerID){
        for(Worker worker : this.workers){
            if(worker.getID() == workerID){// find the worker and remove it from the list
                this.workers.remove(worker);
                return "worker with id " + workerID + " is deleted from system";
            }
        }
        // no worker found, return no worker found message
        return "worker ID not found";
    }

    /**
     * return the list of workers with the given name
     * @param name the worker name that want to search
     * @return the string representations of list of workers with the given name
     */
    public ArrayList<String> searchByName(String name){
        ArrayList<String> workerWithName = new ArrayList<>();
        for(Worker worker : this.workers){
            if(worker.getName().equals(name)){// found worker with given name and convert them to string
                workerWithName.add(worker.toString());
            }
        }
        if(workerWithName.isEmpty()){// if no worker found with the name, return no worker found error
            workerWithName.add("No worker found with the given name");
        }
        return workerWithName;
    }

    /**
     * return all workers in the system
     * @return the string representation of all workers in the system
     */
    public ArrayList<String> allWorker(){
        ArrayList<String> output = new ArrayList<>();
        for(Worker worker :  this.workers){// convert every worker to string and return them
            output.add(worker.toString());
        }
        return output;
    }
}

