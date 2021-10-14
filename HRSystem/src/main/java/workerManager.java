import java.util.*;
public class workerManager {
    public HashMap<Integer, ArrayList<departmentHead>> createWorker(ArrayList<departmentHead> heads, String name, int salary, int ID, String department, String dayOfWeek, String startTime, String endTine){
        HashMap<Integer, ArrayList<departmentHead>> map = new HashMap<>();
        for(departmentHead head : heads){
            if(head.getDepartment().equals(department)){
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

    public String changeSalary(int workerID, int headID, ArrayList<departmentHead> heads, double changePercent){
        for(departmentHead head : heads){
            if(head.getID() == headID){
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
        }
        return "department head not found";
    }

    public String changeSchedule(int workerID, int headID, ArrayList<departmentHead> heads, String dayOfWeek, String startTime, String endTime){
        for(departmentHead head : heads){
            if(head.getID() == headID){
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
        return "no department head found";
    }
}
