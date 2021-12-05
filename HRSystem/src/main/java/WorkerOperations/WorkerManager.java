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
     * Constructor of WorkerManager
     * @param readWriter the readWriter that is used to read and write list of workers to the ser file
     * @param test true when this is used for testing and false when this is used for running program
     */
    public WorkerManager(WorkerReadWriter readWriter, boolean test) throws IOException, ClassNotFoundException {
        // initialize the readWriter to the given readWriter
        this.readWriter = readWriter;
        // initialize the list of workers to list of workers in ser file
        if(test){this.workers = readWriter.readFromFile(workerFile.workerTestFileName());}
        else{this.workers = readWriter.readFromFile(workerFile.workerRunFileName());}
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
     * @param test true when this is used for testing and false when this is used for running program
     * @return the information needed to form output
     */
    public ArrayList<String> createWorker(ArrayList<String> arguments, boolean test) throws IOException {
        // create a new worker with given information and add it to the list of worker
        this.workers.add(new Worker(arguments.get(0), Double.parseDouble(arguments.get(1)), this.nextWorkerID, arguments.get(2), new Schedule(arguments.get(3), arguments.get(4), arguments.get(5))));
        // increase next available id by 1 and return detail of worker to user
        this.nextWorkerID += 1;
        // save the new list of workers to ser file
        if(test){readWriter.saveToFile(workerFile.workerTestFileName(), workers);}
        else{readWriter.saveToFile(workerFile.workerRunFileName(), workers);}
        //return the information
        ArrayList<String> output =  new ArrayList<>();
        output.add(arguments.get(0) + " " + (this.nextWorkerID - 1) + " " + Integer.parseInt(arguments.get(1)) + " " + arguments.get(2));
        return output;
    }

    /**
     * change the salary of the given worker
     * @param workerID the ID of the worker
     * @param changePercent the percent that the salary change where positive mean increase and negative mean decrease
     * @param test true when this is used for testing and false when this is used for running program
     * @return the information needed to form output
     */
    public ArrayList<String> changeSalary(int workerID,  double changePercent, boolean test) throws IOException {
        ArrayList<String> output =  new ArrayList<>();
       for(Worker worker : this.workers){
           if(worker.getID() == workerID){// find the worker with the id and change their salary
               output.add(Double.toString(worker.getSalary()));
               worker.setSalary(worker.getSalary() + worker.getSalary()*changePercent);
               // save the new list to ser file
               if(test){readWriter.saveToFile(workerFile.workerTestFileName(), workers);}
               else{readWriter.saveToFile(workerFile.workerRunFileName(), workers);}
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
     * @param test true when this is used for testing and false when this is used for running program
     * @return the information needed to form output
     */
    public ArrayList<String> changeSchedule(ArrayList<String> arguments, boolean test) throws IOException {
        ArrayList<String> output =  new ArrayList<>();
        for(Worker worker : this.workers){
            if(worker.getID() == Integer.parseInt(arguments.get(0))){// find the worker with the id and change their schedule
                output.add(worker.getSchedule().toString());
                worker.setSchedule(arguments.get(1), arguments.get(2), arguments.get(3));
                // save the new list to ser file
                if(test){readWriter.saveToFile(workerFile.workerTestFileName(), workers);}
                else{readWriter.saveToFile(workerFile.workerRunFileName(), workers);}
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
     * @param test true when this is used for testing and false when this is used for running program
     * @return the information needed to form output
     */
    public ArrayList<String> deleteWorker(int workerID, boolean test) throws IOException {
        ArrayList<String> output =  new ArrayList<>();
        for(Worker worker : this.workers){
            if(worker.getID() == workerID){// find the worker and remove it from the list
                output.add(worker.getName() + " " + worker.getSalary() + " " + worker.getID() + " " + worker.getDepartment() + " " + worker.getSchedule());
                this.workers.remove(worker);
                // store the new list to ser file
                if(test){readWriter.saveToFile(workerFile.workerTestFileName(), workers);}
                else{readWriter.saveToFile(workerFile.workerRunFileName(), workers);}
                output.add("S " + worker.getName() + " " + worker.getID() + " " + worker.getDepartment() + " " + worker.getSalary() + " " + worker.getSchedule().toString());
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
     * return the list of workers' information with the given name
     * @param id the worker name that want to search
     * @return the information needed to form output
     */
    public ArrayList<String> searchByID(int id){
        ArrayList<String> workerWithID = new ArrayList<>();
        for(Worker worker : this.workers){
            if(worker.getID() == id){// found worker with given id
                workerWithID.add(worker.getName() + " " + worker.getID() + " " + worker.getDepartment() + " " + worker.getSalary() + " " + worker.getSchedule().toString());
            }
        }
        if(workerWithID.isEmpty()){// no worker with the given ID, then return no worker found symbol
            workerWithID.add("F");
        }
        return workerWithID;
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

    /**
     * delete all workers in the file
     * @param test true when this is used for testing and false when this is used for running program
     */
    public void deleteAllWorker(boolean test) throws IOException {
        if(test){readWriter.saveToFile(workerFile.workerTestFileName(), new ArrayList<>());}
        else{readWriter.saveToFile(workerFile.workerRunFileName(), new ArrayList<>());}
    }

    /**
     * undo previous create worker
     * @param test true when this is used for testing and false when this is used for running program
     */
    public void undoCreateWorker(boolean test) throws IOException {
        this.deleteWorker((this.nextWorkerID - 1), test);
        if(test){readWriter.saveToFile(workerFile.workerTestFileName(), workers);}
        else{readWriter.saveToFile(workerFile.workerRunFileName(), workers);}
        this.nextWorkerID -= 1;
    }

    /**
     * undo delete worker
     * @param arguments the information needed to undo delete worker
     * @param test true when this is used for testing and false when this is used for running program
     */
    public void undoDeleteWorker(ArrayList<String> arguments, boolean test) throws IOException {
        Worker worker = new Worker(arguments.get(0), Double.parseDouble(arguments.get(1)), Integer.parseInt(arguments.get(2)), arguments.get(3), new Schedule(arguments.get(4), arguments.get(5), arguments.get(6)));
        this.workers.add(Integer.parseInt(arguments.get(2)), worker);
        if(test){readWriter.saveToFile(workerFile.workerTestFileName(), workers);}
        else{readWriter.saveToFile(workerFile.workerRunFileName(), workers);}
    }

    /**
     * undo change salary
     * @param workerID ID of the worker that want to undo change salary
     * @param salary the salary changed to
     * @param test true when this is used for testing and false when this is used for running program
     */
    public void undoChangeSalary(int workerID,  double salary, boolean test) throws IOException {
        for (Worker worker : this.workers) {
            if (worker.getID() == workerID) {
                worker.setSalary(salary);
                if (test) {
                    readWriter.saveToFile(workerFile.workerTestFileName(), workers);
                } else {
                    readWriter.saveToFile(workerFile.workerRunFileName(), workers);
                }
            }
        }
    }
}

