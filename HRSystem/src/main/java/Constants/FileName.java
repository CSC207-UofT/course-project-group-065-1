package Constants;

public class FileName {
    /**
     * return the name of the worker file that is used for running the program
     * @return the file name of worker file that is used for running the program
     */
    public String workerRunFileName(){
        return "workers.ser";
    }

    /**
     * return the name of the department head file that is used for running the program
     * @return the file name of department head file that is used for running the program
     */
    public String headRunFileName(){
        return "heads.ser";
    }

    /**
     * return the name of the worker file that is used for testing the program
     * @return the file name of worker file that is used for testing the program
     */
    public String workerTestFileName(){
        return "workerstest.ser";
    }

    /**
     * return the name of the department head file that is used for testing the program
     * @return the file name of department head file that is used for testing the program
     */
    public String headTestFileName(){
        return "headstest.ser";
    }
}
