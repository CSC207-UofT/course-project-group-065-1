package WorkerOperations;

import Entities.Schedule;
import Entities.Worker;
import Data.*;
import java.io.IOException;
import java.util.*;
import Constants.*;
public class WorkerManager {
    final private ArrayList<Worker> workers;
    private int nextWorkerID;
    ReadWriter readWriter;
    FileName workerFile = new FileName();
    /**
     * Constructor of WorkerCommands.WorkerManager
     */
    public WorkerManager(WorkerReadWriter readWriter) throws IOException, ClassNotFoundException {
        // initialize the readWriter to the given readWriter
        this.readWriter = readWriter;
        // initialize the list of workers to list of workers in ser file
        this.workers = readWriter.readFromFile(workerFile.workerRunFileName());
        // initialize the next available id to 0 if no workers in ser file or to largest id plus on if there is at least one worker
        this.nextWorkerID = -1;
        if(workers.isEmpty()){
            this.nextWorkerID = 0;
        }else{
            for(Worker worker : this.workers){
                if(worker.getID() > this.nextWorkerID){
                    this.nextWorkerID = worker.getID();
                }
            }
            this.nextWorkerID += 1;
        }
    }

    /**
     * create the worker if the input are valid
     * @param arguments list of arguments needed
     * @return the information needed to form output
     */
    public ArrayList<String> createWorker(ArrayList<String> arguments) throws IOException {
        // create a new worker with given information and add it to the list of worker
        this.workers.add(new Worker(arguments.get(0), Integer.parseInt(arguments.get(1)), this.nextWorkerID, arguments.get(2), new Schedule(arguments.get(3), arguments.get(4), arguments.get(5))));
        // increase next available id by 1 and return detail of worker to user
        this.nextWorkerID += 1;
        // save the new list of workers to ser file
        readWriter.saveToFile(workerFile.workerRunFileName(), workers);
        //return the information
        ArrayList<String> output =  new ArrayList<>();
        output.add(arguments.get(0) + " " + (this.nextWorkerID - 1) + " " + Integer.parseInt(arguments.get(1)) + " " + arguments.get(2));
        return output;
    }

    /**
     * change the salary of the given worker
     * @param workerID the ID of the worker
     * @param changePercent the percent that the salary change where positive mean increase and negative mean decrease
     * @return the information needed to form output
     */
    public ArrayList<String> changeSalary(int workerID,  double changePercent) throws IOException {
        ArrayList<String> output =  new ArrayList<>();
       for(Worker worker : this.workers){
           if(worker.getID() == workerID){// find the worker with the id and change their salary
               worker.setSalary(worker.getSalary() + worker.getSalary()*changePercent);
               // save the new list to ser file
               readWriter.saveToFile(workerFile.workerRunFileName(), workers);
               output.add("S " + worker.getName() + " " + worker.getID() + " " + worker.getSalary());
               return output;
           }
       }
       // no worker with the given id, then return no worker found symbol
        output.add("N I"); // N I id short for no id found.
       return output;
    }

    /**
     * change the schedule of the given worker
     * @param arguments list of arguments needed
     * @return the information needed to form output
     */
    public ArrayList<String> changeSchedule(ArrayList<String> arguments) throws IOException {
        ArrayList<String> output =  new ArrayList<>();
        for(Worker worker : this.workers){
            if(worker.getID() == Integer.parseInt(arguments.get(0))){// find the worker with the id and change their schedule
                worker.setSchedule(arguments.get(1), arguments.get(2), arguments.get(3));
                // save the new list to ser file
                readWriter.saveToFile(workerFile.workerRunFileName(), workers);
                output.add("S " + worker.getName() + " " + worker.getID() + " " +
                        worker.getDepartment() + " " + worker.getSchedule().toString());
                return output;
            }
        }
        // no worker with the given id, then return no worker found symbol
        output.add("N I");
        return output;
    }

    /**
     * delete worker with given id
     * @param workerID the id of worker that want to delete
     * @return the information needed to form output
     */
    public ArrayList<String> deleteWorker(int workerID) throws IOException {
        ArrayList<String> output =  new ArrayList<>();
        for(Worker worker : this.workers){
            if(worker.getID() == workerID){// find the worker and remove it from the list
                this.workers.remove(worker);
                // store the new list to ser file
                readWriter.saveToFile(workerFile.workerRunFileName(), workers);
                output.add("S " + workerID);
                return output;
            }
        }
        // no worker with the given id, then return no worker found symbol
        output.add("N I");
        return output;
    }

    /**
     * return the list of workers' information with the given name
     * @param name the worker name that want to search
     * @return the information needed to form output
     */
    public ArrayList<String> searchByName(String name){
        ArrayList<String> workerWithName = new ArrayList<>();
        for(Worker worker : this.workers){
            if(worker.getName().equals(name)){// found worker with given name and convert their information to string
                workerWithName.add(worker.getName() + " " + worker.getID() + " " + worker.getDepartment() + " " + worker.getSalary() + " " + worker.getSchedule().toString());
            }
        }
        if(workerWithName.isEmpty()){// no worker with the given name, then return no worker found symbol
            workerWithName.add("f");
        }
        return workerWithName;
    }

    /**
     * return all workers' information in the system
     * @return the information needed to form output
     */
    public ArrayList<String> allWorker(){
        ArrayList<String> output = new ArrayList<>();
        for(Worker worker :  this.workers){// convert every worker information to string and return them
            output.add(worker.getName() + " " + worker.getID() + " " + worker.getDepartment() + " " + worker.getSalary() + " " + worker.getSchedule().toString());
        }
        return output;
    }
}

