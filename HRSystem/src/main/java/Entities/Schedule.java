package Entities;

import java.io.Serializable;

public class Schedule implements Serializable {
    private String dayOfWeek;
    private String startTime;
    private String endTime;


    /**
     * the constructor for a schedule
     * @param dayOfWeek day of the week that the schedule is on
     * @param startTime the time the schedule start
     * @param endTime the time the schedule end
     */

    public Schedule(String dayOfWeek, String startTime, String endTime){
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * setter for attribute day of week
     * @param dayOfWeek target day of the week that want to be set
     */

    public void setDayOfWeek(String dayOfWeek){
        this.dayOfWeek = dayOfWeek;
    }

    /**
     * setter for attribute start time
     * @param startTime target start time that want to be set
     */
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    /**
     * setter for attribute end time
     * @param endTime target end time that want to be set
     */
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    /**
     * override the builtin toString function to better display schedule
     * @return string representation of a schedule
     */
    @Override
    public String toString(){
        return this.dayOfWeek + " from " + this.startTime + " to " + this.endTime;
    }
}
