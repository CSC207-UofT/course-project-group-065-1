import java.util.*;
public class workerManager {
    /**
     * create the worker if the input are valid
     * @param heads list of all department heads
     * @param name the name of the worker that want to create
     * @param salary the salary of the worker that want to create
     * @param ID the ID of the worker that want to create
     * @param department the department of the worker that want to create
     * @param dayOfWeek the day of the week of the worker's schedule
     * @param startTime the start time of the worker's schedule
     * @param endTine the end time of the worker's schedule
     * @return a map where the integer indicates whether the next avaliable worker Id should be changed or next where 1 means should and 0 means not
     */
    public HashMap<Integer, ArrayList<departmentHead>> createWorker(ArrayList<departmentHead> heads, String name, int salary, int ID, String department, String dayOfWeek, String startTime, String endTine){
        HashMap<Integer, ArrayList<departmentHead>> map = new HashMap<>();
        for(departmentHead head : heads){
            if(head.getDepartment().equals(department)){//check if there is department head for the given department. if not then it shouldn't create worker
                worker newWorker = new worker(name, salary, ID, head.getDepartment(), new schedule(dayOfWeek, startTime, endTine));
                ArrayList<worker> currentWorker = head.getWorkerInDepart();
                currentWorker.add(newWorker);
                head.setWorkerInDepart(currentWorker);
                map.put(1, new ArrayList<>());
                return map;
            }
        }
        map.put(0, heads);
        return map;
    }

    /**
     * change the salary of the given worker
     * @param workerID the ID of the worker
     * @param headID the Id of the department head that request this change
     * @param heads the list of all department heads
     * @param changePercent the percent that the salary change where positive mean increase and negative mean decrease
     * @return the message that the user should see
     */
    public String changeSalary(int workerID, int headID, ArrayList<departmentHead> heads, double changePercent){
        for(departmentHead head : heads){
            if(head.getID() == headID){// check if the department head ID match to one of the existing department head
                ArrayList<worker> workers = head.getWorkerInDepart();
                for(worker worker : workers){// check if the worker is under the department head
                    if(worker.getID() == workerID){// if all true, then change the salary and return successful message
                        worker.setSalary(worker.getSalary() + worker.getSalary()*changePercent);
                        return "the salary of " + worker.getName() + " with id " + worker.getID() + " has been changed to "
                                + worker.getSalary() + " by permission from " + head.getName();
                    }
                }// if the worker is not under the department head, return the corresponding message
                return "department head has no right to change salary for the worker";
            }
        }// if no department head with that ID, return the corresponding message
        return "department head not found";
    }

    /**
     * change the schedule of the given worker
     * @param workerID the ID of the worker
     * @param headID the ID of the department head that request this change
     * @param heads the list of all department heads
     * @param dayOfWeek the day of the week that the schedule should change to
     * @param startTime the start time that the schedule should change to
     * @param endTime the end time that the schedule should change to
     * @return the message the user should see
     */
    public String changeSchedule(int workerID, int headID, ArrayList<departmentHead> heads, String dayOfWeek, String startTime, String endTime){
        for(departmentHead head : heads){// check if the department head ID match to existing department head
            if(head.getID() == headID){
                ArrayList<worker> workers = head.getWorkerInDepart();
                for(worker worker : workers){// check if the worker ID match to a worker under the department
                    if(worker.getID() == workerID){// if all true, then change the schedule and return corresponding message
                        worker.setSchedule(dayOfWeek, startTime, endTime);
                        return "schedule changed for " + worker.getName() + " with id " + worker.getID() + " in " +
                                worker.getDepartment() + " department with current schedule on " + worker.getSchedule().toString();
                    }
                }// if the worker is not under the department, return the corresponding message
                return "department head has no right to change schedule";
            }
        }// if the department head ID doesn't match, then return the corresponding message
        return "no department head found";
    }
}

