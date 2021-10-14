import java.util.*;
public class InOutHandler {
    /*
    handles input

    only focuses on relevant input, extra content at end will be ignored
     */
    Scanner in;

    public InOutHandler(){
        in = new Scanner(System.in);
    }

    public int run(ArrayList<departmentHead> heads, int nextWorkerID, int nextHeadID) {
        /*
        exit - return 0,
        other - return 1
         */

        String[] input = in.nextLine().split(" ");

        if (input[0].equals("exit")) {
            return 0;
        }
        if (input.length() < 2) {
            System.out.println("invalid input");
            return 1;
        }

        boolean printInvalid = false;
        if (input[0].equals("create")) {
            if (input[1].equals("worker")) {
                System.out.println(handleCreateWorker(input, nextWorkerID, workers));
            }
            else if (input.length() > 3 && input[1].equals("department") && input[2].equals("head")) {
                System.out.println(handleCreateDepartmentHead(input, nextHeadID, heads));
            }
            else {
                printInvalid = true;
            }
        }
        else if (input[0].equals("change")) {
            if (input[1].equals("salary")) {
                System.out.println(handleChangeSalary(input, workers, heads));
            }
            else if (input[1].equals("schedule")) {
                System.out.println(handleChangeSchedule(input, workers, heads));
            }
            else {
                printInvalid = true;
            }
        }
        else {
            printInvalid = true;
        }

        if (printInvalid) {
            System.out.println("invalid input");
        }

        return 1;
    }

    private String handleCreateWorker(String input, int id, ArrayList<departmentHead> heads) {
        /*
        if successful, returns string representation of the created worker,
        else returns "invalid input"

        input should be name, salary(int), department, schedule
         */

        if (input.length < 8 || !isInt(input[3]) || !isSchedule(input[5], input[6], input[7])) { //check if input is valid
            return "invalid input"
        }

        //check if schedule is valid - following 'www 0000am 0000pm' format
        String week = input[5], start = input[6], end = input[7];


        String name = input[2];
        int salary = Integer.parseInt(input[3]);
        String dep = input[4];
        schedule sched = new schedule(week, start, end);

        worker newWork = new worker(name, salary, id, dep, sched);
        for (int i = 0; i < heads.length; i++) {
            if (heads.getDepartment().equals(dep)) {
                heads.addWorkerToDepartment(newWork);
            }
        }

        return "name: "+name+" id: "+id+" salary: "+salary+" department: "+dep+" is created";
    }

    private String handleCreateDepartmentHead(String input, int id, ArrayList<departmentHead> heads) {
        /*
        if successful, returns string representation of the created department head,
        else returns "invalid input"

        input should be name, department
         */

        if (input.length < 5) {
            return "invalid input";
        }

        String name = input[3];
        String dep = input[4];

        for (departmentHead h: heads) {
            if (h.getDepartment().equals(dep)) {
                return "there is already a department head for this department!";
            }
        }

        departmentHead newHead = new departmentHead(name, id, dep);

        return "name: "+name+" id: "+id+" department: "+dep+" is created";
    }

    private String handleChangeSalary(String input, ArrayList<departmentHead> heads) {
        /*
        input should be worker id, head id, change percentage(decimal)
         */

        if (input.length < 5 || !isInt(input[2]) || !isInt(input[3]) || !isDouble(input[4])) { //check if input is valid
            return "invalid input";
        }

        int workId = parseInt(input[2]);
        int headId = parseInt(input[3]);
        double per = parseDouble(input[4]);
        departmentHead head;
        worker work;

        //find worker and department head from id
        boolean hfound = false, wfound = false;
        for (departmentHead h: heads) {
            if (h.getID() == headId) {
                hfound = true;
                head = h;
            }
        }
        for (worker w: head.getWorkerInDepart()) {
            if (w.getID() == workId) {
                wfound = true;
                work = w;
            }
        }

        if (!hfound) {
            return "no department head with this id";
        }
        if (!wfound) {
            return "no worker with this id";
        }

        work.setSalary(work.getSalary()*(1+per));

        return "the salary of "+work.getName()+", id: "+work.getID()+", has been changed to "+work.getSalary()+
                " by "+head.getName();
    }

    private String handleChangeSchedule(String input, ArrayList<departmentHead> heads) {
        /*
        input should be worker id, department head id, schedule
         */

        //check if input is valid
        if (input.length < 7 || !isInt(input[2]) || !isInt(input[3]) || !isSchedule(input[4], input[5], input[6])) {
            return "invalid input";
        }

        int wId = input[2];
        int hId = input[3];
        String week = input[4];
        String start = input[5];
        String end = input[6];
        departmentHead h;
        worker w;

        boolean hfound = false, wfound = false;
        //find department head
        for (departmentHead h1: heads) {
            if (h1.getID() == hId) {
                hfound = true;
                h = h1;
            }
        }

        if (!hfound) {
            return "no department head with this id";
        }

        //find worker
        for (worker w1: h.getWorkerInDepart()) {
            if (w1.getID() == wId) {
                wfound = true;
                w = w1;
            }
        }

        if (!wfound) {
            return "no worker with this id in your department";
        }

        w.setSchedule(week, start, end);
        return "schedule changed to "+week+" "+start+"-"+end+" for "+name", id: "+id+" in department"+w.getDepartment();
    }

    private static boolean isInt(String str) {
        /*
        Returns true if str contains only numbers
         */
        return text.matches("[0-9]+");
    }
    private static boolean isDouble(String str) {
        /*
        Returns true if str is a positive/negative number
         */
        return str.matches("/^-?(0|[1-9]\d*)?(\.\d+)?(?<=\d)$/");
    }
    private static boolean isSchedule(String week, String start, String end) {
        /*
        Returns true if a schedule object can be constructed with parameters (week, start, end),
        following 'www 0000am 0000pm' format
         */
        return (["mon", "tue", "wed", "thu", "fri", "sat", "sun"].contains(week)
                && start.length() == 6 || end.length() == 6
                && isInt(start.substring(0, 4)) || isInt(end.substring(0, 4))
                && ["am", "pm"].contains(start.substring(4)) && ["am", "pm"].contains(end.substring(4)))
    }
}
